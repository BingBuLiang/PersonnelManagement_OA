'use strict';
$(document).ready(function () {

    var chartColors = {
        primary: {
            base: '#3f51b5',
            light: '#c0c5e4'
        },
        danger: {
            base: '#f2125e',
            light: '#fcd0df'
        },
        success: {
            base: '#0acf97',
            light: '#cef5ea'
        },
        warning: {
            base: '#ff8300',
            light: '#ffe6cc'
        },
        info: {
            base: '#00bcd4',
            light: '#e1efff'
        },
        dark: '#37474f',
        facebook: '#3b5998',
        twitter: '#55acee',
        linkedin: '#0077b5',
        instagram: '#517fa4',
        whatsapp: '#25D366',
        dribbble: '#ea4c89',
        google: '#DB4437',
        borderColor: '#e8e8e8',
        fontColor: '#999'
    };

    if ($('body').hasClass('dark')) {
        chartColors.borderColor = 'rgba(255, 255, 255, .1)';
        chartColors.fontColor = 'rgba(255, 255, 255, .4)';
    }

    var Duzenli = /linear-gradient\((.*)(\)\))/;
    var Sonuc1 = Duzenli.exec($('body .side-menu .side-menu-body a .icon').css('background'));
    var Duzenli2 = /rgb\((.*)\), rgb\((.*)\)\)/;
    var Sonuc2 = Duzenli2.exec(Sonuc1[0]);

    var themeColor1 = 'rgb(' + Sonuc2[1] + ')';
    var themeColor2 = 'rgb(' + Sonuc2[2] + ')';

    chartjs_one();

    chartjs_two();

    chartjs_three();

    chartjs_four();

    chartjs_five();

    chartjs_six();

    chartjs_seven();

    chartjs_eight();

    chartjs_nine();

    chartjs_ten();

    chartjs_eleven();

    chartjs_twelve();

    chartjs_thirteen();

    comments_chart_demo();

    function chartjs_one() {
        var element = document.getElementById("chartjs_one");
        if (element) {
            element.height = 200;

            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            new Chart(element, {
                type: 'bar',
                data: {
                    labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
                    datasets: [
                        {
                            label: "Population (millions)",
                            backgroundColor: color,
                            hoverBackgroundColor: color,
                            hoverBorderWidth: 2,
                            data: [2478, 5267, 734, 784, 433]
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: 'Predicted world population (millions) in 2050'
                    },
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_two() {
        var element = document.getElementById("chartjs_two");
        if (element) {
            element.height = 200;
            new Chart(element, {
                type: 'line',
                data: {
                    labels: [1500, 1600, 1700, 1750, 1800, 1850, 1900, 1950, 1999, 2050],
                    datasets: [{
                        data: [86, 114, 106, 106, 107, 111, 133, 221, 783, 2478],
                        label: "Africa",
                        borderColor: "#3e95cd",
                        fill: false
                    }, {
                        data: [282, 350, 411, 502, 635, 809, 947, 1402, 3700, 2267],
                        label: "Asia",
                        borderColor: "#8e5ea2",
                        fill: false
                    }, {
                        data: [168, 170, 178, 190, 203, 276, 408, 547, 675, 734],
                        label: "Europe",
                        borderColor: "#3cba9f",
                        fill: false
                    }, {
                        data: [40, 120, 110, 16, 24, 38, 74, 167, 508, 784],
                        label: "Latin America",
                        borderColor: "#e8c3b9",
                        fill: false
                    }, {
                        data: [6, 100, 50, 130, 70, 26, 82, 172, 312, 433],
                        label: "North America",
                        borderColor: "#c45850",
                        fill: false
                    }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: 'World population per region (in millions)'
                    },
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_three() {
        var element = document.getElementById("chartjs_three");
        if (element) {
            element.height = 200;
            new Chart(element, {
                type: 'pie',
                data: {
                    labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
                    datasets: [{
                        label: "Population (millions)",
                        backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                        data: [2478, 5267, 734, 784, 433]
                    }]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Predicted world population (millions) in 2050'
                    }
                }
            });
        }
    }

    function chartjs_four() {
        var element = document.getElementById("chartjs_four");
        if (element) {
            element.height = 200;
            new Chart(element, {
                type: 'radar',
                data: {
                    labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
                    datasets: [
                        {
                            label: "1950",
                            fill: true,
                            backgroundColor: "rgba(179,181,198,0.2)",
                            borderColor: "rgba(179,181,198,1)",
                            pointBorderColor: "#fff",
                            pointBackgroundColor: "rgba(179,181,198,1)",
                            data: [8.77, 55.61, 21.69, 6.62, 6.82]
                        }, {
                            label: "2050",
                            fill: true,
                            backgroundColor: "rgba(255,99,132,0.2)",
                            borderColor: "rgba(255,99,132,1)",
                            pointBorderColor: "#fff",
                            pointBackgroundColor: "rgba(255,99,132,1)",
                            data: [25.48, 54.16, 7.61, 8.06, 4.45]
                        }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Distribution in % of world population'
                    },
                }
            });
        }
    }

    function chartjs_five() {
        var element = document.getElementById("chartjs_five");
        if (element) {
            element.height = 200;

            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            new Chart(element, {
                type: 'horizontalBar',
                data: {
                    labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
                    datasets: [
                        {
                            label: "Population (millions)",
                            backgroundColor: color,
                            hoverBackgroundColor: color,
                            data: [2478, 5267, 734, 784, 433]
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: 'Predicted world population (millions) in 2050'
                    },
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_six() {
        var element = document.getElementById("chartjs_six");
        if (element) {
            element.height = 200;

            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            new Chart(element, {
                type: 'bar',
                data: {
                    labels: ["1900", "1950", "1999", "2050"],
                    datasets: [{
                        label: "Europe",
                        type: "line",
                        borderColor: "#8e5ea2",
                        data: [408, 547, 675, 734],
                        fill: false
                    }, {
                        label: "Africa",
                        type: "line",
                        borderColor: "#3e95cd",
                        data: [133, 221, 783, 2478],
                        fill: false
                    }, {
                        label: "Europe",
                        type: "bar",
                        backgroundColor: color,
                        hoverBackgroundColor: color,
                        data: [408, 547, 675, 734],
                    }, {
                        label: "Africa",
                        type: "bar",
                        backgroundColor: color,
                        hoverBackgroundColor: color,
                        data: [133, 221, 783, 2478]
                    }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Population growth (millions): Europe & Africa'
                    },
                    legend: {display: false},
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_seven() {
        var element = document.getElementById("chartjs_seven");
        if (element) {
            element.height = 115;

            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            new Chart(element, {
                type: 'bar',
                data: {
                    labels: ["Jan", "Fen", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"],
                    datasets: [{
                        label: "Europe",
                        type: "bar",
                        backgroundColor: color,
                        hoverBackgroundColor: color,
                        data: [408, 547, 675, 734, 122, 323, 94, 312, 282, 500, 800, 1050],
                    }, {
                        label: "Africa",
                        type: "bar",
                        backgroundColor: color,
                        hoverBackgroundColor: color,
                        data: [133, 221, 783, 1478, 821, 321, 400, 200, 820, 300, 511, 100]
                    }]
                },
                options: {
                    title: {
                        display: false
                    },
                    legend: {display: false},
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_eight() {
        var element = document.getElementById("chartjs_eight");
        if (element) {
            element.height = 155;
            new Chart(element, {
                type: 'line',
                data: {
                    labels: [1500, 1600, 1700, 1750, 1800, 1850, 1900, 1950, 1999, 2050],
                    datasets: [{
                        data: [2186, 2000, 1900, 2300, 2150, 2100, 2350, 2500, 2400, 2390],
                        label: "Mobile",
                        borderColor: chartColors.primary.base,
                        fill: false
                    }, {
                        data: [1282, 1000, 1290, 1302, 1400, 1250, 1350, 1402, 1700, 1967],
                        label: "Desktop",
                        borderColor: chartColors.success.base,
                        fill: false
                    }, {
                        data: [500, 700, 900, 800, 600, 850, 900, 550, 750, 690],
                        label: "Other",
                        borderColor: chartColors.warning.base,
                        fill: false
                    }]
                },
                options: {
                    title: {
                        display: false
                    },
                    legend: {display: false},
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                }
            });
        }
    }

    function chartjs_nine() {
        var ctx = document.getElementById("chartjs_nine");
        if (ctx) {
            new Chart(ctx.getContext("2d"), {
                type: 'doughnut',
                data: {
                    datasets: [{
                        data: [15, 25, 10, 30],
                        backgroundColor: [
                            chartColors.success.light,
                            chartColors.danger.light,
                            chartColors.warning.light,
                            chartColors.info.light
                        ],
                        label: 'Dataset 1'
                    }],
                    labels: [
                        'Social Media',
                        'Organic Search',
                        'Referrral',
                        'Email'
                    ]
                },
                options: {
                    elements: {
                        arc: {
                            borderWidth: 0
                        }
                    },
                    responsive: true,
                    legend: {
                        display: false
                    },
                    title: {
                        display: false
                    },
                    animation: {
                        animateScale: true,
                        animateRotate: true
                    }
                }
            });
        }
    }

    function chartjs_ten() {
        var element = document.getElementById("chartjs_ten");
        if (element) {
            new Chart(element.getContext("2d"), {
                type: 'line',
                data: {
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: [{
                        backgroundColor: themeColor1,
                        label: "Desktop",
                        data: [31, 74, 6, 39, 20, 85, 7],
                        pointRadius: 5,
                        borderWidth: 0
                    }, {
                        backgroundColor: themeColor2,
                        label: "Mobile",
                        data: [82, 23, 66, 9, 99, 4, 50],
                        pointRadius: 5,
                        borderWidth: 0
                    }]
                },
                options: {
                    legend: {
                        labels: {
                            fontColor: chartColors.fontColor
                        }
                    },
                    responsive: true,
                    maintainAspectRatio: true,
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    },
                    elements: {
                        point: {
                            radius: 3
                        }
                    },
                    layout: {
                        padding: {
                            left: 0,
                            right: 0,
                            top: 0,
                            bottom: 0
                        }
                    },
                    stepsize: 1
                }
            });
        }
    }

    function chartjs_eleven() {
        var element = document.getElementById('chartjs_eleven');
        if (element) {

            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            new Chart(element.getContext('2d'), {
                type: 'line',
                data: {
                    labels: ["Jun 2016", "Jul 2016", "Aug 2016", "Sep 2016", "Oct 2016", "Nov 2016", "Dec 2016", "Jan 2017", "Feb 2017", "Mar 2017", "Apr 2017", "May 2017"],
                    datasets: [{
                        label: "Rainfall",
                        backgroundColor: color,
                        hoverBackgroundColor: color,
                        data: [26.4, 39.8, 66.8, 66.4, 40.6, 55.2, 77.4, 69.8, 57.8, 76, 110.8, 142.6],
                    }]
                },
                options: {
                    legend: {
                        display: false,
                        labels: {
                            fontColor: chartColors.fontColor
                        }
                    },
                    title: {
                        display: false,
                        text: 'Precipitation in Toronto',
                        fontColor: chartColors.fontColor,
                    },
                    scales: {
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            },
                            scaleLabel: {
                                display: true,
                                labelString: 'Precipitation in mm',
                                fontColor: chartColors.fontColor,
                            }
                        }],
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        }
    }

    function chartjs_twelve() {
        var element = document.getElementById("chartjs_twelve");
        if (element) {

            element.height = 130;

            new Chart(element.getContext("2d"), {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                    datasets: [{
                        fill: false,
                        label: 'Primary',
                        borderDash: [2, 2],
                        borderColor: themeColor1,
                        data: [-20, 30, -20, 0, 25, 44, 30],
                        pointRadius: 5,
                        pointHoverRadius: 7
                    }, {
                        fill: false,
                        label: 'Success',
                        borderDash: [2, 2],
                        borderColor: themeColor2,
                        data: [30, 33, 22, 39, -30, 19, -37],
                        pointRadius: 5,
                        pointHoverRadius: 7
                    }]
                },
                options: {
                    responsive: true,
                    legend: {
                        labels: {
                            fontColor: chartColors.fontColor
                        }
                    },
                    title: {
                        display: false,
                        fontColor: chartColors.fontColor
                    },
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor,
                                min: -50,
                                max: 50
                            }
                        }]
                    }
                }
            });
        }
    }

    function chartjs_thirteen() {
        var element = document.getElementById('chartjs_thirteen');

        if (element) {
            var color = element.getContext('2d').createLinearGradient(0, 0, 0, 600);
            color.addColorStop(0, themeColor1);
            color.addColorStop(1, themeColor2);

            window.myBar = new Chart(element.getContext('2d'), {
                type: 'bar',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May'],
                    datasets: [
                        {
                            label: 'Dataset 1',
                            backgroundColor: color,
                            hoverBackgroundColor: color,
                            yAxisID: 'y-axis-1',
                            data: [33, 56, -40, 25, 45]
                        },
                        {
                            label: 'Dataset 2',
                            backgroundColor: color,
                            hoverBackgroundColor: color,
                            yAxisID: 'y-axis-2',
                            data: [23, 86, -40, 5, 45]
                        }
                    ]
                },
                options: {
                    legend: {
                        labels: {
                            fontColor: chartColors.fontColor
                        }
                    },
                    responsive: true,
                    title: {
                        display: true,
                        text: 'Chart.js Bar Chart - Multi Axis',
                        fontColor: chartColors.fontColor
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                            gridLines: {
                                color: chartColors.borderColor
                            },
                            ticks: {
                                fontColor: chartColors.fontColor
                            }
                        }],
                        yAxes: [
                            {
                                type: 'linear',
                                display: true,
                                position: 'left',
                                id: 'y-axis-1',
                            },
                            {
                                gridLines: {
                                    color: chartColors.borderColor
                                },
                                ticks: {
                                    fontColor: chartColors.fontColor
                                }
                            },
                            {
                                type: 'linear',
                                display: true,
                                position: 'right',
                                id: 'y-axis-2',
                                gridLines: {
                                    drawOnChartArea: false
                                },
                                ticks: {
                                    fontColor: chartColors.fontColor
                                }
                            }
                        ],
                    }
                }
            });
        }
    }

    function comments_chart_demo() {
        if ($('#comments_chart_demo').length) {
            var ctx = document.getElementById("comments_chart_demo").getContext("2d");
            var speedData = {
                labels: ["0s", "10s", "20s", "30s", "40s", "50s", "60s"],
                datasets: [{
                    label: "Car Speed (mph)",
                    borderColor: 'white',
                    backgroundColor: 'rgba(0, 0, 0, 0',
                    data: [0, 59, 75, 20, 20, 55, 40]
                }]
            };
            var chartOptions = {
                legend: {
                    scaleFontColor: "#FFFFFF",
                    display: false,
                    position: 'top',
                    labels: {
                        boxWidth: 80,
                        fontColor: 'black'
                    }
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            color: 'rgba(255, 255, 255, .2)'
                        },
                        ticks: {
                            fontColor: 'rgba(255, 255, 255, .7)'
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            color: 'rgba(255, 255, 255, .2)'
                        },
                        ticks: {
                            fontColor: 'rgba(255, 255, 255, .7)'
                        }
                    }]
                }
            };
            new Chart(ctx, {
                type: 'line',
                data: speedData,
                options: chartOptions
            });
        }
    }

    function sparkline_mode1() {
        if ($(".sparkline-demo1").length) {
            $(".sparkline-demo1").sparkline([9, 6, 8, 9, 4, 6, 3, 6, 9, 4, 7, 4, 7], {
                width: '100%',
                height: 100,
                type: 'line',
                fillColor: $('body').hasClass('dark') ? chartColors.primary.base : chartColors.primary.light,
                spotColor: false,
                minSpotColor: false,
                maxSpotColor: false,
                lineColor: chartColors.primary.base,
                lineWidth: 1
            });
        }
    }

    function sparkline_mode2() {
        if ($(".sparkline-demo2").length) {
            $(".sparkline-demo2").sparkline([5, 4, 8, 3, 4, 5, 3, 5, 9, 4, 7, 4, 2], {
                width: '100%',
                height: 100,
                type: 'line',
                fillColor: $('body').hasClass('dark') ? chartColors.danger.base : chartColors.danger.light,
                lineColor: chartColors.danger.base,
                spotColor: false,
                minSpotColor: false,
                maxSpotColor: false,
                lineWidth: 1
            });
        }
    }

    function sparkline_mode3() {
        if ($(".sparkline-demo3").length) {
            $(".sparkline-demo3").sparkline([9, 6, 3, 9, 4, 5, 3, 6, 9, 4, 7, 4, 7], {
                width: '100%',
                height: 100,
                type: 'line',
                fillColor: $('body').hasClass('dark') ? chartColors.success.base : chartColors.success.light,
                lineColor: chartColors.success.base,
                spotColor: false,
                minSpotColor: false,
                maxSpotColor: false,
                lineWidth: 1
            });
        }
    }

    function sparkline_mode4() {
        if ($(".sparkline-demo4").length) {
            $(".sparkline-demo4").sparkline([9, 6, 8, 9, 4, 5, 3, 6, 9, 4, 7, 4, 7], {
                width: '100%',
                height: 100,
                type: 'line',
                fillColor: $('body').hasClass('dark') ? chartColors.warning.base : chartColors.warning.light,
                lineColor: chartColors.warning.base,
                spotColor: false,
                minSpotColor: false,
                maxSpotColor: false,
                lineWidth: 1
            });
        }
    }

    function chart_func_run() {
        sparkline_mode1();
        sparkline_mode2();
        sparkline_mode3();
        sparkline_mode4();
    }

    $(window).on('resize', chart_func_run());
});