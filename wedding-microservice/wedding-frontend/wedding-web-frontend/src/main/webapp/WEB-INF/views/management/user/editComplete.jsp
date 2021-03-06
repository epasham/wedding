<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://debugroom.org/tags" prefix="d"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>User Edit Complete</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/flex.css" media="(min-width: 1280px)">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/flex_mobile.css" media="(min-width: 320px) and (max-width: 767px)">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/flex_tablet.css" media="(min-width: 768px) and (max-width: 1279px)">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/management/user/editComplete.css" media="(min-width: 1280px)">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/management/user/editComplete_mobile.css" media="(min-width: 320px) and (max-width: 767px)">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/resources/app/css/management/user/editComplete_tablet.css" media="(min-width: 768px) and (max-width: 1279px)">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" 
    src="${pageContext.request.contextPath}/static/resources/app/js/common/menu.js"></script>
</head>
<body>
  <c:import url="/WEB-INF/views/common/header.jsp" />
  <article>
    <div id="flex-container">
      <div class="flex-item-1">
       <c:import url="/WEB-INF/views/common/menu.jsp" />
      </div>
      <div class="flex-item-2">
        <div class="panel">
          <div class="resultPanel">
            <p>以下の通り、更新されました。</p>
              <c:forEach items="${updateResult.updateParamList}" var="updateParam" varStatus="status">
                <table>
                  <tbody>
                    <c:choose>
                      <c:when test="${updateParam == 'lastName'}">
                        <tr>
                          <th colspan="2">苗字</th>
                        </tr>
                        <tr>
                          <th>更新前</th>
                          <th>更新後</th>
                        </tr>
                        <tr>
                          <td>
                            <spring:nestedPath path="updateResult.beforeEntity" >
                              <spring:bind path="lastName">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                          <td>
                            <spring:nestedPath path="updateResult.afterEntity" >
                              <spring:bind path="lastName">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                        </tr>
                      </c:when>
                      <c:when test="${updateParam == 'firstName'}">
                        <tr>
                          <th colspan="2">名前</th>
                        </tr>
                        <tr>
                          <th>更新前</th>
                          <th>更新後</th>
                        </tr>
                        <tr>
                          <td>
                            <spring:nestedPath path="updateResult.beforeEntity" >
                              <spring:bind path="firstName">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                          <td>
                            <spring:nestedPath path="updateResult.afterEntity" >
                              <spring:bind path="firstName">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                        </tr>
                      </c:when>
                      <c:when test="${updateParam == 'loginId'}">
                        <tr>
                          <th colspan="2">ログインID</th>
                        </tr>
                        <tr>
                          <th>更新前</th>
                          <th>更新後</th>
                        </tr>
                        <tr>
                          <td>
                            <spring:nestedPath path="updateResult.beforeEntity" >
                              <spring:bind path="loginId">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                          <td>
                            <spring:nestedPath path="updateResult.afterEntity" >
                              <spring:bind path="loginId">${status.value}</spring:bind>
                            </spring:nestedPath>
                          </td>
                        </tr>
                      </c:when>
                      <c:when test="${updateParam == 'imageFile'}">
                      <tr>
                        <th colspan="2">ピクチャ</th>
                      </tr>
                      <tr>
                        <th colspan="2">更新後</th>
                      </tr>
                      <tr>
                        <td colspan="2">
                          <spring:nestedPath path="updateResult.afterEntity" >
                            <spring:bind path="imageFilePath">
                              <c:choose>
                                <c:when test='${fn:endsWith(updateResult.afterEntity.imageFilePath,"png")}'>
                                  <img src='${pageContext.request.contextPath}/management/profile/image/<c:out value="${updateResult.afterEntity.userId}/xxxx.png" />'>
                                </c:when>
                                <c:when test='${fn:endsWith(updateResult.afterEntity.imageFilePath,"jpg")}'>
                                  <img src='${pageContext.request.contextPath}/management/profile/image/<c:out value="${updateResult.afterEntity.userId}/xxxx.jpg" />'>
                                </c:when>
                                <c:when test='${fn:endsWith(updateResult.afterEntity.imageFilePath,"jpeg")}'>
                                  <img src='${pageContext.request.contextPath}/management/profile/image/<c:out value="${updateResult.afterEntity.userId}/xxxx.jpg" />'>
                                </c:when>
                                <c:when test='${fn:endsWith(updateResult.afterEntity.imageFilePath,"gif")}'>
                                  <img src='${pageContext.request.contextPath}/management/profile/image/<c:out value="${updateResult.afterEntity.userId}/xxxx.gif" />'>
                                </c:when>
                              </c:choose>
                            </spring:bind>
                          </spring:nestedPath>
                        </td>
                      </tr>
                    </c:when>
                    <c:when test="${updateParam == 'address.postCd'}">
                      <tr>
                        <th colspan="2">郵便番号</th>
                      </tr>
                      <tr>
                        <th>更新前</th>
                        <th>更新後</th>
                      </tr>
                      <tr>
                        <td>
                          <spring:nestedPath path="updateResult.beforeEntity" >
                            <spring:bind path="address.postCd">${status.value}</spring:bind>
                          </spring:nestedPath>
                        </td>
                        <td>
                          <spring:nestedPath path="updateResult.afterEntity" >
                            <spring:bind path="address.postCd">${status.value}</spring:bind>
                          </spring:nestedPath>
                        </td>
                      </tr>
                    </c:when>
                    <c:when test="${updateParam == 'credentials#PASSWORD'}">
                      <tr>
                        <th colspan="2">パスワード※セキュリティのため、表示されません。</th>
                      </tr>
                      <tr>
                        <th>更新前</th>
                        <th>更新後</th>
                      </tr>
                      <tr>
                        <td>
                        ******
                        </td>
                        <td>
                        ******
                        </td>
                      </tr>
                    </c:when>
                     <c:when test="${updateParam == 'authorityLevel'}">
                        <tr>
                          <th colspan="2">権限レベル</th>
                        </tr>
                        <tr>
                          <th>更新前</th>
                          <th>更新後</th>
                        </tr>
                        <tr>
                          <td>
                            <c:if test='${updateResult.beforeEntity.brideSide == true}'>
                            新婦側
                            </c:if>
                            <c:if test='${updateResult.beforeEntity.brideSide == false}'>
                            新郎側
                            </c:if>
                          </td>
                          <td>
                            <c:if test='${updateResult.afterEntity.brideSide == true}'>
                            新婦側
                            </c:if>
                            <c:if test='${updateResult.afterEntity.brideSide == false}'>
                            新郎側
                            </c:if>
                          </td>
                        </tr>
                      </c:when>
                    <c:when test="${updateParam == 'address.address'}">
                    <tr>
                      <th colspan="2">住所</th>
                    </tr>
                    <tr>
                      <th>更新前</th>
                      <th>更新後</th>
                    </tr>
                    <tr>
                      <td>
                        <spring:nestedPath path="updateResult.beforeEntity" >
                          <spring:bind path="address.address">${status.value}</spring:bind>
                        </spring:nestedPath>
                      </td>
                      <td>
                        <spring:nestedPath path="updateResult.afterEntity" >
                          <spring:bind path="address.address">${status.value}</spring:bind>
                        </spring:nestedPath>
                      </td>
                    </tr>
                  </c:when>
                  <c:when test="${fn:startsWith(updateParam, 'emails')}">
                    <tr>
                      <th colspan="2">Email # ${fn:substringAfter(updateParam, '#')}</th>
                    </tr>
                    <tr>
                      <th>更新前</th>
                      <th>更新後</th>
                    </tr>
                    <tr>
                      <td>
                        <c:forEach var="email" items="${updateResult.beforeEntity.emails}">
                          <c:if test="${email.id.emailId == fn:substringAfter(updateParam, '#')}">
                            <c:out value="${email.email}" />
                          </c:if>
                        </c:forEach>
                      </td>
                      <td>
                        <c:forEach var="email" items="${updateResult.afterEntity.emails}">
                          <c:if test="${email.id.emailId == fn:substringAfter(updateParam, '#')}">
                            <c:out value="${email.email}" />
                          </c:if>
                        </c:forEach>
                      </td>
                    </tr>
                  </c:when>
                  <c:when test="${updateParam == 'isBrideSide'}">
                    <tr>
                      <th colspan="2">列席</th>
                    </tr>
                    <tr>
                      <th>更新前</th>
                      <th>更新後</th>
                    </tr>
                    <tr>
                      <td>
                        <c:if test='${updateResult.beforeEntity.brideSide == true}'>
                        新婦側
                        </c:if>
                        <c:if test='${updateResult.beforeEntity.brideSide == false}'>
                        新郎側
                        </c:if>
                      </td>
                      <td>
                        <c:if test='${updateResult.afterEntity.brideSide == true}'>
                        新婦側
                        </c:if>
                        <c:if test='${updateResult.afterEntity.brideSide == false}'>
                        新郎側
                        </c:if>
                      </td>
                    </tr>
                  </c:when>
                </c:choose>
              </tbody>
            </table>
          </c:forEach>
          <button class="main-button" type="button"
                onclick="location.href='${pageContext.request.contextPath}/management/user/portal'" >ユーザ一覧に戻る</button>
        </div>
      </div>
    </div>
  </div>
  </article>
</body>