<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <script src="/entities/claim_detail.js"></script>

            <%@ page isELIgnored= "false" %>

                <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                <html>

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                    <style>
                        .blue {
                            color: #0000ff
                        }
                        
                        .red {
                            color: #FF5733
                        }
                        .mess {text:'IN-PROCESS';}
                    </style>

                </head>

                <body>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset-2 " id="alert">
                                <h4 style="color:red">${msg}</h4></div>
                        </div>

                        <div >
                            <form action="/search" method="GET">
                                <div class="row">
                                    <div class="col-sm-2 col-sm-offset-1">
                                        <label for="empId">EMPLOYEE ID</label>
                                        <select id="empId" name="empId" class="form-control">
                                            <c:forEach var="emp" items="${employees}">
                                                <option value="${emp}">${emp}</option>
                                            </c:forEach>
                                        </select>

                                    </div>

                                    <div class="col-sm-2">
                                        <div class="startDate">
                                            <label for="startDate">START DATE</label>
                                            <input type="date" class="form-control" id="startDate" name="startDate" class="btn btn-primary">
                                        </div>

                                    </div>

                                    <div class="col-sm-2">
                                        <div class="claimDate">
                                            <label for="claimDate">END DATE</label>
                                            <input type="date" class="form-control" id="endDate" name="endDate" class="btn btn-primary">
                                        </div>

                                    </div>
                                    <br>
                                    <div class="col-sm-2">
                                        <label for="save"></label>
                                        <input type="submit" value="Search" class="btn btn-primary" />
                                    </div>
                                    <div class="col-sm-2">
                                        <label for="list"></label>
                                        <a href="" class="btn btn-primary">Get All</a>
                                    </div>

                                </div>

                        </div>

                    </div>
                    

                    <div class="row">
                        <div class="col-sm-2 col-sm-offset-1">

                            <table class="table table-responsive" id="DisplayTable">
                                <tr>
                                </tr>
                                <tr>
                                    <th>EMP_ID
                                        <th>
                                            <th>CLAIM_ID</th>
                                            <th>TO_MAIL_ID</th>
                                            <th>FROM_MAIL_ID</th>
                                            <th>CLAIM_DATE</th>
                                            <th>CLAIM_CODE</th>
                                            <th>CLAIM_TYPE</th>
                                            <th>CLAIM_AMOUNT</th>
                                            <th>CLAIM_VERSION</th>
                                            <td>IS_USER_COMMIT</td>
                                            <td>STATUS</td>
                                </tr>

                                <c:forEach var="claim" items="${claims}">
                                    <tr>
                                        <td>${claim.empId}
                                            <td>
                                                <td>${claim.id}</td>
                                                <td>${claim.toMailId}</td>
                                                <td>${claim.fromMailId}</td>
                                                <td>
                                                    <fmt:formatDate pattern="dd-MMM-yyyy" value="${claim.claimDate}" />
                                                </td>
                                                <td>${claim.claimCode}</td>
                                                <td>${claim.claimType}</td>
                                                <td>${claim.claimAmount}</td>
                                                <td>${claim.claimVersion}</td>
                                                <td id="isUserCommit">${claim.isUserCommit}</td>

                                                <td class="${claim.status=='APPROVED'? 'blue':'red'}">${claim.status}</td>
                                                <!-- <td>${claim.status}</td> -->
                                                <td><a href="showUpdate/${claim.id}">EDIT</a></td>
                                                <td  id="approve"><span></span><a href="/showUpdate1/${claim.id}" ><p> <font face="verdana" color="green">${claim.status=='APPROVED'?'':'APPROVE'}</font></p></a></td>
                                    </tr>

                                </c:forEach>

                            </table>
                        </div>
                    </div>

					<script>
					
				/* 	var val = document.getElementById("isUserCommit").innerHTML;
					alert(val) */
					;
					/* for (i=0; i < 2; i++){
					    var aptDate = $('#isUserCommit'+i).text();
					    alert(aptDate);
					  
					 }
					
					 */
					</script>


                    <!--  <script>
                        $(document).ready(function() {
                            function disablePrev() {
                                window.history.forward()
                            }
                            window.onload = disablePrev();
                            window.onpageshow = function(evt) {
                                if (evt.persisted) disableBack()
                            }
                        });
                    </script> -->
                </body>

                </html>