function tu1() {
   var tuDiv =  document.getElementById("tuDiv");
    var tu1 = document.createElement("canvas");
    tu1.setAttribute("id","demoChart");
    tuDiv.appendChild(tu1);
    var chartInit1 = $('#demoChart').get(0).getContext("2d");
    new Chart(chartInit1, {
        type: 'line'
        ,data: {
            labels: ['Jan.', 'Feb.', 'Mar.', 'Apr.', 'May.', 'June.', 'July.', 'Aug.', 'Sept.', 'Oct.', 'Nov.', 'Dec']
            // labels: ${emps}
            ,datasets: [{
                label: '工资'
                ,borderWidth: 2
                ,borderColor: 'rgba(30, 144, 255, 1)'
                ,backgroundColor: 'rgba(30, 144, 255, 0.7)'
                ,data: [3500, 3000, 4000, 3700, 3200, 3500, 3400, 3600, 3200, 3500, 3800, 6800]
            }]
        },
        // 加了这个x轴, y轴最低数据就从0开始算, 不加就从最低的那个数据开始算
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        min: 0
                    }
                }]
            }
        }
    });
}
function tu2() {
    var tuDiv =  document.getElementById("tuDiv");
    var tu2 = document.createElement("canvas");
    tu2.setAttribute("id","myChat");
    tuDiv.appendChild(tu2);
    var ctx = $('#myChat');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
                data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false,
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
    line(tuDiv);
}
function line(tuDiv) {
    var line = document.createElement("hr");
    tuDiv.appendChild(line);
}
function tu3() {
    var chartInit1 = $('#demoChart1').get(0).getContext("2d");
    new Chart(chartInit1, {
        type: 'bar'
        ,data: {
            labels: ['Jan.', 'Feb.', 'Mar.', 'Apr.', 'May.', 'June.']
            ,datasets: [{
                label: '工资'
                ,borderWidth: 2
                ,borderColor: 'rgba(30, 144, 255, 1)'
                ,backgroundColor: 'rgba(30, 144, 255, 0.7)'
                ,data: [3500, 3000, 4000, 3700, 3200, 3500]
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        min: 0
                    }
                }]
            }
        }
    });
}
function tu4() {
    var chartInit2 = $('#demoChart2').get(0).getContext("2d");
    new Chart(chartInit2, {
        type: 'radar'
        ,data: {
            labels: ['Jan.', 'Feb.', 'Mar.', 'Apr.', 'May.', 'June.', 'July.', 'Aug.', 'Sept.', 'Oct.', 'Nov.', 'Dec']
            ,datasets: [{
                label: '胖虎工资'
                ,borderWidth: 2
                ,borderColor: 'rgba(30, 144, 255, 1)'
                ,backgroundColor: 'rgba(30, 144, 255, 0.7)'
                ,data: [3500, 3000, 4000, 3700, 3200, 3500, 3400, 3600, 3200, 3500, 3800, 6800]
            },{
                label: '静香工资'
                ,borderWidth: 2
                ,borderColor: 'rgba(0, 0, 0, 1)'
                ,backgroundColor: 'rgba(0, 0, 0, 0.7)'
                ,data: [3000, 3200, 4100, 3200, 3000, 3200, 3100, 3300, 3000, 3100, 3600, 5800]
            }]
        },
        options: {
            // 需要特别注意的是: 这里的scale没有s
            scale: {
                ticks: {
                    min: 0
                }
            }
        }
    });
}
function tu5() {
    var chartInit3 = $('#demoChart3').get(0).getContext("2d");
    new Chart(chartInit3, {
        type: 'doughnut'// or 'pie'
        ,data: {
            labels: ['Jan.', 'Feb.', 'Mar.', 'Apr.', 'May.', 'June.']
            ,datasets: [{
                label: '工资'
                ,borderWidth: 0
                ,backgroundColor: ['red', 'orange', 'yellow', 'green', 'cyan', 'blue']
                ,data: [3500, 3000, 4000, 3700, 3200, 3500]
                ,lineTension: 1
            }]
        },
    });
}