/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JBoss EAP 8.0 Update 2.0 (WildFly Core 21.0.9.Final-redhat-00001) - 2.3.11.SP1-redhat-00001
 * Generated at: 2024-06-30 21:41:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class jsonPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private jakarta.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
        throws java.io.IOException, jakarta.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(jakarta.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      response.addHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>JSON Test</title>\n");
      out.write("  <style>\n");
      out.write("    form * {\n");
      out.write("      margin-bottom: 10px;\n");
      out.write("      margin-top: 10px;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<button onclick=\"sendCorrectJson()\">Send Correct JSON</button>\n");
      out.write("<button onclick=\"sendIncorrectJson()\">Send Incorrect JSON</button>\n");
      out.write("<button onclick=\"showCustomJsonForm()\">Send Custom JSON</button>\n");
      out.write("\n");
      out.write("<div id=\"customJsonForm\" style=\"display:none;\">\n");
      out.write("  <h2>Custom JSON Form</h2>\n");
      out.write("  <form id=\"jsonForm\">\n");
      out.write("    <label for=\"request_id\">Request ID:</label>\n");
      out.write("    <input type=\"text\" id=\"request_id\" name=\"request_id\"><br>\n");
      out.write("    <label for=\"loan_id\">Loan ID:</label>\n");
      out.write("    <input type=\"text\" id=\"loan_id\" name=\"loan_id\"><br>\n");
      out.write("    <label for=\"terminal_id\">Terminal ID:</label>\n");
      out.write("    <input type=\"text\" id=\"terminal_id\" name=\"terminal_id\"><br>\n");
      out.write("    <label for=\"merchant_id\">Merchant ID:</label>\n");
      out.write("    <input type=\"text\" id=\"merchant_id\" name=\"merchant_id\"><br>\n");
      out.write("    <label for=\"nspc_trans_id\">NSPC Trans ID:</label>\n");
      out.write("    <input type=\"text\" id=\"nspc_trans_id\" name=\"nspc_trans_id\"><br>\n");
      out.write("    <label for=\"amount\">Amount:</label>\n");
      out.write("    <input type=\"text\" id=\"amount\" name=\"amount\"><br>\n");
      out.write("    <label for=\"commission_amount\">Commission Amount:</label>\n");
      out.write("    <input type=\"text\" id=\"commission_amount\" name=\"commission_amount\"><br>\n");
      out.write("    <label for=\"payment_type\">Payment Type:</label>\n");
      out.write("    <input type=\"text\" id=\"payment_type\" name=\"payment_type\"><br>\n");
      out.write("    <label for=\"card_type\">Card Type:</label>\n");
      out.write("    <input type=\"text\" id=\"card_type\" name=\"card_type\"><br>\n");
      out.write("    <label for=\"authorization_code\">Authorization Code:</label>\n");
      out.write("    <input type=\"text\" id=\"authorization_code\" name=\"authorization_code\"><br>\n");
      out.write("    <label for=\"payment_date\">Payment Date:</label>\n");
      out.write("    <input type=\"text\" id=\"payment_date\" name=\"payment_date\"><br>\n");
      out.write("    <label for=\"operation_number\">Operation Number:</label>\n");
      out.write("    <input type=\"text\" id=\"operation_number\" name=\"operation_number\"><br>\n");
      out.write("    <button type=\"button\" onclick=\"sendCustomJson()\">Send</button>\n");
      out.write("  </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("  function sendCorrectJson() {\n");
      out.write("    fetch('/frnx_proj/api/validate', {\n");
      out.write("      method: 'POST',\n");
      out.write("      headers: {\n");
      out.write("        'Content-Type': 'application/json'\n");
      out.write("      },\n");
      out.write("      body: JSON.stringify({\n");
      out.write("        \"request_id\": \"3285950\",\n");
      out.write("        \"loan_id\": \"41515070\",\n");
      out.write("        \"terminal_id\": \"91600062\",\n");
      out.write("        \"merchant_id\": \"9160006245\",\n");
      out.write("        \"nspc_trans_id\": \"7415627\",\n");
      out.write("        \"amount\": \"80000\",\n");
      out.write("        \"commission_amount\": \"1\",\n");
      out.write("        \"payment_type\": \"4\",\n");
      out.write("        \"card_type\": \"HUMO\",\n");
      out.write("        \"authorization_code\": \"6FE05113-6183-403F-9283-CE08499121E4\",\n");
      out.write("        \"payment_date\": \"27.03.2020\",\n");
      out.write("        \"operation_number\": \"45451\"\n");
      out.write("      })\n");
      out.write("    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function sendIncorrectJson() {\n");
      out.write("    fetch('/frnx_proj/api/validate', {\n");
      out.write("      method: 'POST',\n");
      out.write("      headers: {\n");
      out.write("        'Content-Type': 'application/json'\n");
      out.write("      },\n");
      out.write("      body: JSON.stringify({\n");
      out.write("        \"request_id\": \"\",\n");
      out.write("        \"loan_id\": \"41515070\",\n");
      out.write("        \"terminal_id\": \"91600062\",\n");
      out.write("        \"merchant_id\": \"9160006245\",\n");
      out.write("        \"nspc_trans_id\": \"7415627\",\n");
      out.write("        \"amount\": \"eight thousand\",\n");
      out.write("        \"commission_amount\": \"1\",\n");
      out.write("        \"payment_type\": \"4\",\n");
      out.write("        \"card_type\": \"HUMO\",\n");
      out.write("        \"authorization_code\": \"6FE05113-6183-403F-9283-CE08499121E4\",\n");
      out.write("        \"payment_date\": \"27.03.2020\",\n");
      out.write("        \"operation_number\": \"45451\"\n");
      out.write("      })\n");
      out.write("    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function showCustomJsonForm() {\n");
      out.write("    document.getElementById(\"customJsonForm\").style.display = \"block\";\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function sendCustomJson() {\n");
      out.write("    const form = document.getElementById('jsonForm');\n");
      out.write("    const formData = new FormData(form);\n");
      out.write("    const jsonObject = {};\n");
      out.write("    formData.forEach((value, key) => {\n");
      out.write("      jsonObject[key] = value;\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    fetch('/frnx_proj/api/validate', {\n");
      out.write("      method: 'POST',\n");
      out.write("      headers: {\n");
      out.write("        'Content-Type': 'application/json'\n");
      out.write("      },\n");
      out.write("      body: JSON.stringify(jsonObject)\n");
      out.write("    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));\n");
      out.write("  }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new jakarta.servlet.ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
