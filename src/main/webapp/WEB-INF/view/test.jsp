<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <script language="javascript" type="text/javascript" src="/web-content/jqPlot/jquery.min.js"></script>
    <script language="javascript" type="text/javascript" src="/web-content/jqPlot/jquery.jqplot.min.js"></script>
    <script type="text/javascript" src="/web-content/jqPlot/plugins/jqplot.dateAxisRenderer.js"></script>
    <link rel="stylesheet" type="text/css" href="/web-content/jqPlot/jquery.jqplot.css"/>
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

    $(document).ready(function () {

            var data = JSON.parse('${data}');
            var myData = {};
            myData.currency = $("select[name = 'currencyCodeFrom']").val();

            myData.ratesHigh = [];
            myData.ratesLow = [];
            for (let i = 0; i < data.Data.length; i++) {

                let date = new Date(data.Data[i].time * 1000);
                let year = date.getFullYear();
                let month = date.getMonth() + 1;
                if (month < 10) {
                    month = '0' + month;
                }
                let day = date.getDate() + 1;
                if (day < 10) {
                    day = '0' + day;
                }
                let dateString = year + '-' + month + '-' + day;

                myData.ratesHigh[i] = [];
                myData.ratesHigh[i][0] = dateString;
                myData.ratesHigh[i][1] = data.Data[i].high;

                myData.ratesLow[i] = [];
                myData.ratesLow[i][0] = dateString;
                myData.ratesLow[i][1] = data.Data[i].low;

            }


            var plot1 = $.jqplot('chartdiv', [myData.ratesHigh, myData.ratesLow], {
                axes: {
                    xaxis: {
                        renderer: $.jqplot.DateAxisRenderer,
                        tickOptions: {formatString: '%Y-%m-%d'},
                    }
                }
            })
        }
    );
</script>
</body>
</html>