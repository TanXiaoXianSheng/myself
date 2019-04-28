<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <link rel="stylesheet" href="/template/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/template/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/template/css/styles.css">
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <@block name="header">

    </@block>

    <div class="main-container">
        <@block name="sidebar">sidebar</@block>

        <@block name="content">content</@block>
    </div>
</div>
<script src="/template/vendor/jquery/jquery.min.js"></script>
<script src="/template/vendor/popper.js/popper.min.js"></script>
<script src="/template/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/template/vendor/chart.js/chart.min.js"></script>
<script src="/template/js/carbon.js"></script>
<script src="/template/js/demo.js"></script>
</body>
</html>
