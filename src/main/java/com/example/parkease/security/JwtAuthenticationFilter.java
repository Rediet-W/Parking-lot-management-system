// package com.example.parkease.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.OncePerRequestFilter;
// import org.springframework.stereotype.Component;

// @Component
// @RequiredArgsConstructor
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws java.io.IOException, jakarta.servlet.ServletException {

//         String authHeader = request.getHeader("Authorization");

//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String token = authHeader.substring(7);
//         String username = jwtUtil.extractUsername(token);

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                     username, null, jwtUtil.extractAuthorities(token));
//             SecurityContextHolder.getContext().setAuthentication(authentication);
//         }

//         filterChain.doFilter(request, response);
//     }
// }
