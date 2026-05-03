package org.kareem.springcloud.apigetwayservice.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println("Pre Processing: " + req.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("Post Processing done!");
    }
}