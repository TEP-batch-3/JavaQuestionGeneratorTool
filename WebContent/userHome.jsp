<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page language="java" import="java.util.*,java.io.*,java.lang.ClassNotFoundException,java.io.IOException,java.sql.SQLException" %>
<%@ page language="java" import="com.tcs.ilp.iquest.util.*" %>
<%@ page language="java" import="com.tcs.qgt.bean.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
	<link rel="stylesheet" href="assets/js/multiselect.min.js">
		<link rel="stylesheet" href="assets/css/multiselect.css">
</head>
	<style>
		/* example of setting the width for multiselect */
		#testSelect1_multiSelect {
			width: 200px;
		}
	</style>
<body class="adminbody">
<%
HttpSession session2 = request.getSession();
Connection conn = DbTransaction.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = null;
String query = null;
int l1 = 0;
int l2 = 0;
String level ="<span class = 'result'></span>"; 
if(null == session2.getAttribute("Role") ){
	response.sendRedirect("logout.jsp");   
    }
else{
%>
<jsp:include page="header.jsp"></jsp:include>
<% 
    }
%>
<div class="container container-fluid">
<form method="post" action="QuestionGenrateServlet">
<div class="form-group row">
<div class="col-sm-2"></div>
    <label for="exampleFormControlSelect1" class="col-sm-2 col-form-label">Entity :</label>
   <div class="col-sm-6">
    <select class="form-control" id="entity" name="entity">
     <!--  <option value="Employee">Employee</option> -->
      <%
         query = "Select * from TBL_Entity";
    		try{
    			 rs = stmt.executeQuery(query);
    			 while(rs.next())
					{
					String title = rs.getString("title"); 
					%>
					<option value="<%=title %>"><%=title %></option>
					<%
					}
    		}catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
				}
         %> 
    </select>
    </div>
  </div>
    <div class="form-group row " id="level">
    <div class="col-sm-2"> 
    </div>
    <label for="inputPassword" class="col-sm-2 col-form-label">Operation :</label>
    <div class="col-sm-4" style="margin-top: 7px;">
    <label class="form-check-label" for="inlineRadio1">Level 1</label>
               <input class="form-check-input" type="radio" id="l1" style="margin-left: 15px;margin-top: 6px;" name="level" value="1" onclick="show()" >
	</div>
    <div class="col-sm-4" style="margin-top: 7px;">
    <label class="form-check-label" for="inlineRadio1">Level 2</label>     
             <input class="form-check-input" type="radio" id="l2" style="margin-left: 15px;margin-top: 6px;" name="level"  value="2" onclick="show()" > 
    </div>
	</div>
<div class="form-group row" id="lev1" style=" display:none;margin-left: 34%;width: 49%;">
	 <div class="col-sm-2"></div>
	  <div class="col-sm-6"></div>
       <div class="col-sm-6">
        <input type="text" id="op1" class="btn btn-default btn-sm dropdown-toggle form-control" data-toggle="dropdown" value="Select the Operations" ><span class="caret"></span>
	<div class="dropdown-menu level1"id="lev1checkbox" style="background-color: white;
    box-shadow: 0.5px 0.5px 0.5px 1px rgba(0,0,0,0.56);">
	<%
			query = "Select * from TBL_OPERATION where level = 1";
    		try{
    			 rs = stmt.executeQuery(query);
    			l1 = 0;
    			 while(rs.next())
					{
					String title = rs.getString("title"); 
					%>
					<label for="<%=title %>">
					<a href="#" class="small" data-value="<%=title %>" tabIndex="-1"><input type="checkbox" name="level1Operations" id="opselect1" value="<%=title %>"/>&nbsp;<%=title %><br></a> 
                  </label>
					<%
				l1++;
					}
    		}catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
				}
         %> </div>
</div>
</div>
<div class="form-group row" id="lev2" style=" display:none;margin-left: 34%;width: 49%;">
	 <div class="col-sm-2"></div>
	  <div class="col-sm-6"></div>
       <div class="col-sm-6">
        <input type="text" id="op2" class="btn btn-default btn-sm dropdown-toggle form-control" data-toggle="dropdown" value="Select the Operations" ><span class="caret"></span>
	<div class="dropdown-menu level2"id="lev2checkbox" style="background-color: white;
    box-shadow: 0.5px 0.5px 0.5px 1px rgba(0,0,0,0.56);">
	<%
			query = "Select * from TBL_OPERATION where level = 2";
    		try{
    			 rs = stmt.executeQuery(query);
    			l2 = 0;
    			 while(rs.next())
					{
					String title = rs.getString("title"); 
					%>
					<label for="<%=title %>">
					<a href="#" class="small" data-value="<%=title %>" tabIndex="-1"><input type="checkbox" name="level2Operations" id="opselect2" value="<%=title %>"/>&nbsp;<%=title %><br></a> 
                  </label>
					<%
				l2++;
					}
    		}catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
				}
         %> </div>
</div>
</div>  <div class="form-group row">
    <div class="col-sm-2"></div>
      <div class="col-sm-2">No Of Questions :</div>
      <div class="col-sm-6">
      <input class="form-control" type="number" name="NOQ" id ="noq" value=""> 
      </div>      
  </div>
  <div class="form-group row">
    <div class="col-sm-2"></div>
      <div class="col-sm-2">Private Test Cases :</div>
      <div class="col-sm-6">
      <input class="form-control" type="number" name="PTC" value="2"> 
      </div>      
  </div>
  <div class="form-group row">
    <div class="col-sm-2"></div>
      <div class="col-sm-2">Public Test Cases :</div>
      <div class="col-sm-6">
      <input class="form-control" type="number" name="PTCS" value="2"> 
      </div>      
  </div>
  <div class="button1 column2">
          <input class="btn1 btn-info bb btn btn-outline-success " type="submit" name="Submit"
            value="Generate">
        </div>
        <input type="hidden" id="checkcount1" name="checkcount1" value="0">
  		<input type="hidden" id="checkcount2" name="checkcount2"value="0">
</form>
	<span style="font-size: xx-small; color:red;">Note : Double Click to select the Radio button </span>
  </div>
<script type="text/javascript">
/* radio Button values */
var level
$('input[type=radio]').click(function(e) {

	level = $(this).val();
	 if(level == 1){
		 document.getElementById("noq").value = '<%= l1 %>';
	 }
	 if(level == 2){
		 document.getElementById("noq").value = '<%= l2 %>';
	 } 
      $('.result').html(level);

  });
/*   Display the operations */
	 var options1 = [];
var options2 = [];
var count1 = 0;
var count2 = 0;
$( '.level1 a' ).on( 'click', function( event ) {

   var $target = $( event.currentTarget ),
       val = $target.attr( 'data-value' ),
       $inp = $target.find( 'input' ),
       idx;

   if ( ( idx = options1.indexOf( val ) ) > -1 ) {
      options1.splice( idx, 1 );
      setTimeout( function() { $inp.prop( 'checked', false ) }, 0);
      count1--;
   } else {	
      options1.push( val );
      setTimeout( function() { $inp.prop( 'checked', true ) }, 0);
      count1++;
   }
   var $checkboxes = $('#lev2checkbox input[type="checkbox"]');
   $( event.target ).blur();
   document.getElementById("op1").value = options1 ;
   document.getElementById("checkcount1").value = count1 ;
   console.log( options1 );
   return false;
});

$( '.level2 a' ).on( 'click', function( event ) {

   var $target = $( event.currentTarget ),
       val = $target.attr( 'data-value' ),
       $inp = $target.find( 'input' ),
       idx;

   if ( ( idx = options2.indexOf( val ) ) > -1 ) {
      options2.splice( idx, 1 );
      setTimeout( function() { $inp.prop( 'checked', false ) }, 0);
      count2--;
   } else {
      options2.push( val );
      setTimeout( function() { $inp.prop( 'checked', true ) }, 0);
      count2++;
   }
   $( event.target ).blur();
   document.getElementById("op2").value = options2 ;
   document.getElementById("checkcount2").value = count2 ;
   console.log( options2 );
   return false;
});
/* show the input box based on radio values */
 function show() {
	  var x = document.getElementById("lev1");
	  var y = document.getElementById("lev2");
	  if (x.style.display === "none" && y.style.display === "none" && level == 1) {
		  x.style.display = "block";
		  y.style.display = "none";
	  }
	  else if (x.style.display === "none" && y.style.display === "none" && level == 2 )
	  {
		  x.style.display = "none";
		  y.style.display = "block";
	  }
	  else if (x.style.display === "block" && y.style.display === "none" && level == 1  )
	  {
		  x.style.display = "block";
		  y.style.display = "none";
	  }
	  else if (x.style.display === "block" && y.style.display === "none" && level == 2  )
	  {
		  y.style.display = "block";
		  x.style.display = "none";
	  }
	  else if (y.style.display === "block" && x.style.display === "none" && level == 1  )
	  {
		  x.style.display = "block";
		  y.style.display = "none";
	  }
	  else if (y.style.display === "block" && x.style.display === "none" && level == 2  )
	  {
		  y.style.display = "block";
		  x.style.display = "none";
	  }
	  else {
	    x.style.display = "none";
	  y.style.display = "none";
	  }
	}
</script>
  </body>

</html>