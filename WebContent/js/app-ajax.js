$(document).ready(function(){
$("button").click(function(e)
{
e.preventDefault();
var countryCode=parseInt($(this).val());
alert("hello:::"+countryCode);

$.ajax({
url : "DemoJsonServlet?countryCode="+countryCode,
type :"get",
data: countryCode,
dataType:"json",

success: function(data,textStatus,jqXHR)
{
if(data.success){
alert("succeed");
$("templatemo_content_right").html(" ");
alert("down111");
$("templatemo_content_right").append("<p>"+data.countryInfo.bookId+"<p>");
$("templatemo_content_right").append("<h3>Book name:</b>"+data.countryInfo.bookName+"</h3><br/>");
$("templatemo_content_right").append("<b>Author name:</b>"+data.countryInfo.authorName+"<br/>");
}
}
});
});

});






























