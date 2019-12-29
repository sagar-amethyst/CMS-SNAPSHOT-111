<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Claim Details</title>
</head>
<body>
<pre>
	<form  action="saveClaim" method="POST">
		CLAIM_ID:<input type="number" name="id"/>
		EMP_ID:<input type="text" name="empId"/>
		TO_MAIL_ID:<input type="text" name="toMailId"/>
		FROM_MAIL_ID:<input type="text" name="fromMailId"/>
		FROM_MAILID_USER_NAME:<input type="text" name="fromMaildUserName"/>
		CLAIM_DATE:<input type="date" path="claimDate" class= "date" name = "claimDate" value = "<fmt:formatDate value="${cForm.claimDate}" pattern="yyyy-MM-dd" />"/>
		TRANSACTION_DATE:<input type="date" name="transactionDate"/>
		CLAIM_CODE:<input type="text" name="claimCode"/>
		CLAIM_TYPE:<input type="text" name="claimType"/>
		CLAIM_DESCRIPTION:<input type="text" name="claimDescription"/>
		CURRENCY_TYPE:<input type="text" name="currencyType"/>
		CLAIM_AMOUNT:<input type="text" name="claimAmount"/>
		CLAIM_VERSION:<input type="text" name="claimVersion"/>
		CLAIM_SECTION:<input type="text" name="claimSection"/>
		ATTACHMENT_NAME:<input type="text" name="attachmentName"/>
		ATTACHMENT_SEQUENCE:<input type="text" name="attachmentSequence"/>
		PROCESS_TIME_STAMP:<input type="date" name="processTimeStamp"/>
		IS_USER_COMMIT:<input type="text" name="isUserCommit"/>
		<input type="submit" value="save"/>
	</form>
	<a href="allClaims">view all</a>
</pre>

</body>
</html>