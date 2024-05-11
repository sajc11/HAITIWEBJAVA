window.onload = function() {
    // Population Chart
    new Chart(document.getElementById('populationChart'), {
        type: 'line',
        data: {
            labels: ["2010", "2015", "2020", "2025"],
            datasets: [{
                label: 'Population',
                data: [10, 10.5, 11, 11.5],
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // GDP Chart
    new Chart(document.getElementById('gdpChart'), {
        type: 'bar',
        data: {
            labels: ["2010", "2015", "2020", "2025"],
            datasets: [{
                label: 'GDP (in billion USD)',
                data: [8, 9, 10, 11],
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Life Expectancy Chart
    new Chart(document.getElementById('lifeExpectancyChart'), {
        type: 'pie',
        data: {
            labels: ["2010", "2015", "2020", "2025"],
            datasets: [{
                label: 'Life Expectancy',
                data: [62, 64, 66, 68],
                backgroundColor: [
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        }
    });
};
