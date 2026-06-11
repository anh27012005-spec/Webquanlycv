package web.quan.ly.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import web.quan.ly.entity.User;
import web.quan.ly.entity.UserSession;
import web.quan.ly.service.UserSessionService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserSessionService userSessionService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7).trim();

        if (token.isEmpty()
                || token.equalsIgnoreCase("null")
                || token.equalsIgnoreCase("undefined")) {

            filterChain.doFilter(request, response);
            return;
        }

        try {

            System.out.println("=================================");
            System.out.println("TOKEN NHAN DUOC:");
            System.out.println(token);

            UserSession session = userSessionService.findByToken(token);

            System.out.println("SESSION:");
            System.out.println(session);

            if (session == null) {
                System.out.println("Khong tim thay token trong DB");
                filterChain.doFilter(request, response);
                return;
            }

            if (session.getExpiredAt() != null
                    && session.getExpiredAt().isBefore(LocalDateTime.now())) {

                System.out.println("Token da het han");

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            User user = session.getUser();

            if (user == null) {
                System.out.println("Session khong co user");
                filterChain.doFilter(request, response);
                return;
            }

            String roleName = user.getRole().getName();

            System.out.println("USER = " + user.getUsername());
            System.out.println("ROLE = " + roleName);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            List.of(
                                    new SimpleGrantedAuthority(
                                            "ROLE_" + roleName
                                    )
                            )
                    );

            authentication.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);

            System.out.println("Da set Authentication thanh cong");

        } catch (Exception e) {

            System.out.println("===== JWT FILTER ERROR =====");
            e.printStackTrace();

        }

        filterChain.doFilter(request, response);
    }
}