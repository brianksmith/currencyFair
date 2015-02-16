<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {

        var data = google.visualization.arrayToDataTable(${data});

        var options = {
          title: '',
          pieHole: 0.4,
          legend: 'none',
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body style="background-color: #999;">
    <div style="width: 300px; height: 250px;">
      <div style="background-color: #ebebeb; color: #666; font-family: Futura Today; font-size: 16px; line-height: 20px; padding: 0 23px; vertical-align: middle;">Currency Transactions by Exchange</div>
      <div id="donutchart" style="width: 300px; height:250px; background-color: #ececed; border-bottom: 1px solid #ccc; border-top: 1px solid #ccc; box-shadow: 0 1px 2px #ccc;"></div>
    </div>
    
  </body>
</html>