<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="/css/bootstrap.min.css">
                <title>Create Claim Details</title>
            </head>

            <body>
                <div class="container">

                    <form action="/saveClaim" method="POST">
                        <table class="table table-condensed">
                            <tr>
                                <br>
                                <br>
                                <thead>CLAIM DETAILS</thead>
                                <br>

                            </tr>
                            <br>
                            <tr>
                                <td class="form-group">CLAIM ID</td>
                                <td>
                                    <input type="number" name="id" value="${claim.id}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">EMP ID</td>
                                </td>
                                <td>
                                    <input type="text" name="empId" value="${claim.empId}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">TO MAIL ID</td>
                                <td>
                                    <input type="text" name="toMailId" value="${claim.toMailId}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">FROM MAIL ID</td>
                                <td>
                                    <input type="text" name="fromMailId" value="${claim.fromMailId}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">FROM MAILID USER NAME</td>
                                <td>
                                    <input type="text" name="fromMaildUserName" value="${claim.fromMaildUserName}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM DATE</td>
                                <td>
                                    <input type="date" name="claimDate" value="${claim.claimDate}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">TRANSACTION DATE</td>
                                <td>
                                    <input type="date" name="transactionDate" value="${claim.transactionDate}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM CODE</td>
                                <td>
                                    <input type="text" name="claimCode" value="${claim.claimCode}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM TYPE</td>
                                <td>
                                    <input type="text" name="claimType" value="${claim.claimType}" readonly="readonly" / class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM DESCRIPTION</td>
                                <td>
                                    <input type="text" name="claimDescription" value="${claim.claimDescription}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CURRENCY TYPE</td>
                                <td>
                                    <input type="text" name="currencyType" value="${claim.currencyType}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM_AMOUNT</td>
                                <td>
                                    <input type="text" name="claimAmount" value="${claim.claimAmount}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM_VERSION</td>
                                <td>
                                    <input type="text" name="claimVersion" value="${claim.claimVersion}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">CLAIM SECTION</td>
                                <td>
                                    <input type="text" name="claimSection" value="${claim.claimSection}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>

                            <tr>
                                <td class="form-group">ATTACHMENT_NAME></td>
                                <td>
                                    <input type="text" name="attachmentName" value="${claim.attachmentName}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">ATTACHMENT_SEQUENCE</td>
                                <td>
                                    <input type="number" name="attachmentSequence" value="${claim.attachmentSequence}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>

                            <tr>
                                <td class="form-group">PROCESS_TIME_STAMP</td>
                                <td>
                                    <input type="date" name="processTimeStamp" value="${claim.processTimeStamp}" readonly="readonly" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group">IS_USER_COMMIT</td>
                                <td>
                                    <input type="text" name="isUserCommit" value="${claim.isUserCommit}" class="form-control" />
                                </td>
                            </tr>

                            <tr>
                                <td class="form-group">STATUS</td>
                                <td>
                                    <input type="text" name="status" value="${claim.status}" class="form-control" />
                                </td>
                            </tr>
                            <tr>
                                <td class="form-group"></td>
                                <td>
                                    <input type="submit" value="save" class="form-control" class="btn btn-primary">
                                </td>
                            </tr>

                        </table>

                    </form>

                </div>
                <script src="/js/jquery.js"></script>
                <script src="/js/bootstrap.min.js"></script>
            </body>

            </html>

            <%-- 		CLAIM_DATE:<input type="date" path="claimDate" class= "date" name = "claimDate" value = "<fmt:formatDate value="${claim.claimDate}" pattern="yyyy-MM-dd" />"/>--%>