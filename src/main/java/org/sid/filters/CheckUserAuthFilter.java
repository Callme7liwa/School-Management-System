package org.sid.filters;

import java.io.IOException;
import java.security.Key;

import org.sid.utils.KeyUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class CheckUserAuthFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) {              
        } 

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                FilterChain chain)
                throws IOException, ServletException {
            
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            HttpSession session = httpServletRequest.getSession();
            if (!httpServletRequest.getRequestURI().contains("login")) {
                try {
                    if( httpServletRequest.getRequestURI().equals(KeyUtils.PREFIX_REDIRECTING) || httpServletRequest.getRequestURI().equals(KeyUtils.PREFIX_REDIRECTING+"authentication"))
                    {
                        chain.doFilter(request, response);
                    }
                    else
                    {
                        if (session.getAttribute("user") == null) {
                            String currentUrl = httpServletRequest.getRequestURL().toString();
                            session.setAttribute("currentUrl", currentUrl);
                            httpServletResponse.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"login");
                        } else {
                            chain.doFilter(request, response);
                        }           
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else 
            {
                if(session.getAttribute("user") == null)
                    chain.doFilter(request, response);
                else
                    httpServletResponse.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"dashboard");
            }
        }

        @Override
        public void destroy() {        
        }


    
}
