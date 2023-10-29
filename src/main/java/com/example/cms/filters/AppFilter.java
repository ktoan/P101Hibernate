package com.example.cms.filters;

import com.example.cms.dao.impl.MemberDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ToanNK16
 * @birthdate Sep 2nd 2002
 * @project P101Hibernate
 * @createdAt 10/28/2023
 */
public class AppFilter implements Filter {
  private final List<String> ignoredRoutes = List.of("/login", "/register");
  private final MemberDAO memberDAO = new MemberDAO();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }

  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    String requestURI = request.getRequestURI();
    HttpSession session = null;
    String email = null;

    if (ignoredRoutes.contains(requestURI)) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      session = request.getSession();
      if (session.getAttribute("email") != null) {
        email = session.getAttribute("email").toString();
      }
      if (email == null) {
        response.sendRedirect("/login");
      } else {
        if (memberDAO.existByEmail(email)) {
          filterChain.doFilter(servletRequest, servletResponse);
        } else {
          session.removeAttribute("email");
          response.sendRedirect("/login");
        }
      }
    }
  }
}
