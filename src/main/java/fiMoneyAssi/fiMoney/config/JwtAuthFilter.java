/*package fiMoneyAssi.fiMoney.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter implements Filter {

    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String authHeader = req.getHeader("Authorization");


        System.out.println("🌐 Requested URI: " + uri);

        if (uri.startsWith("/swagger-ui") ||
                uri.startsWith("/v3/api-docs") ||
                uri.startsWith("/swagger-resources") ||
                uri.startsWith("/webjars") ||
                uri.equals("/swagger-ui.html") ||
                uri.equals("/favicon.ico") ||
                uri.equals("/login") ||
                uri.equals("/register")) {

            chain.doFilter(request, response);
            return;
        }



        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("❌ Missing or malformed Authorization header");
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.getWriter().write("Missing or invalid Authorization header");
            return;
        }


        String token = authHeader.substring(7);
        System.out.println("🔐 Extracted token: " + token);


        if (!jwtUtil.validateToken(token)) {
            System.out.println("❌ Token is INVALID");
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.getWriter().write("Invalid JWT token");
            return;
        }


        System.out.println("✅ Token is valid — request allowed");
        chain.doFilter(request, response);
    }
}*/


