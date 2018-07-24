<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <script language="javascript" type="text/javascript" src="/web-content/jqPlot/jquery.min.js"></script>
    <script language="javascript" type="text/javascript" src="/web-content/jqPlot/jquery.jqplot.min.js"></script>
    <script type="text/javascript" src="/web-content/jqPlot/plugins/jqplot.dateAxisRenderer.js"></script>
    <link rel="stylesheet" type="text/css" href="/web-content/jqPlot/jquery.jqplot.css" />
</head>
<body>
<h1>CryptoCurrency exchange rates</h1>
<div class="form">
    <form class="form" id="form">
        <select name="currencyCodeFrom">
            <option value="gbp">GBP</option>
            <option value="usd">USD</option>
            <option value="eur">EUR</option>
            <option value="chf">CHF</option>
        </select>
        <select name="currencyCodeTo">
            <option value="ETC">ETC</option>
            <option value="BTC">BTC</option>
        </select>
        <label class="form.label">Start Date</label>
        <input type="date" name="startDate">
        <label>End Date</label>
        <input type="date" name="endDate">
        <input type="submit" id="submit">
    </form>
</div>
<div class="chart">
    <h2 class="h2" id="currency"></h2>
    <span id="span"></span>
    <div class="chartdiv" id="chartdiv"></div>
</div>
<p>${test}</p>
<p>${data}</p>
<p>${data}</p>

<script>

    $(document).ready(function(){
        var myData = '';
                    var plot1 = $.jqplot('chartdiv', [myData], {
                        axes:{
                            xaxis:{
                                renderer:$.jqplot.DateAxisRenderer,
                                tickOptions:{formatString:'%Y-%m-%d'},
                            }
                        }
                    })});
</script>
</body>
</html>