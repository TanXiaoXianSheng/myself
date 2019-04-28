<@override name="header">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="#">
            <img src="/template/imgs/logo.png" alt="logo">
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">
            <#--提醒-->
            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-bell"></i>
                    <span class="badge badge-pill badge-danger">5</span>
                </a>
            </li>

            <#--邮件-->
            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-envelope-open"></i>
                    <span class="badge badge-pill badge-danger">5</span>
                </a>
            </li>

            <#--个人-->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="/template/imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                    <span class="small ml-1 d-md-down-none">John Smith</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">Account</div>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-user"></i> Profile
                    </a>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-envelope"></i> Messages
                    </a>

                    <div class="dropdown-header">Settings</div>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-bell"></i> Notifications
                    </a>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-wrench"></i> Settings
                    </a>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-lock"></i> Logout
                    </a>
                </div>
            </li>
        </ul>
    </nav>
</@override>

<@override name="sidebar">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-title">导航条</li>

                <li class="nav-item">
                    <a href="/" class="nav-link active">
                        <i class="icon icon-speedometer"></i> 首页
                    </a>
                </li>

                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle">
                        <i class="icon icon-target"></i> 布局 <i class="fa fa-caret-left"></i>
                    </a>

                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a href="/index/layouts-normal" class="nav-link">
                                <i class="icon icon-target"></i> 正常的
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/layouts-fixed-sidebar" class="nav-link">
                                <i class="icon icon-target"></i> 固定样式
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/layouts-fixed-header" class="nav-link">
                                <i class="icon icon-target"></i> Fixed Header
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/layouts-hidden-sidebar" class="nav-link">
                                <i class="icon icon-target"></i> Hidden Sidebar
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle">
                        <i class="icon icon-energy"></i> UI <i class="fa fa-caret-left"></i>
                    </a>

                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a href="/index/alerts" class="nav-link">
                                <i class="icon icon-energy"></i> Alerts
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/buttons" class="nav-link">
                                <i class="icon icon-energy"></i> Buttons
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/cards" class="nav-link">
                                <i class="icon icon-energy"></i> Cards
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/modals" class="nav-link">
                                <i class="icon icon-energy"></i> Modals
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/tabs" class="nav-link">
                                <i class="icon icon-energy"></i> Tabs
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/progress-bars" class="nav-link">
                                <i class="icon icon-energy"></i> 进度条(Progress Bars)
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/widgets" class="nav-link">
                                <i class="icon icon-energy"></i> Widgets
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle">
                        <i class="icon icon-graph"></i> 图表 <i class="fa fa-caret-left"></i>
                    </a>

                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a href="/index/charts" class="nav-link">
                                <i class="icon icon-graph"></i> 图表
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a href="/index/forms" class="nav-link">
                        <i class="icon icon-puzzle"></i> 表单
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/index/tables" class="nav-link">
                        <i class="icon icon-grid"></i> 表格
                    </a>
                </li>

                <#--<li class="nav-title">More</li>

                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle">
                        <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                    </a>

                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a href="/index/blank" class="nav-link">
                                <i class="icon icon-umbrella"></i> Blank Page
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/login" class="nav-link">
                                <i class="icon icon-umbrella"></i> Login
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/register" class="nav-link">
                                <i class="icon icon-umbrella"></i> Register
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/invoice" class="nav-link">
                                <i class="icon icon-umbrella"></i> Invoice
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/404" class="nav-link">
                                <i class="icon icon-umbrella"></i> 404
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/500" class="nav-link">
                                <i class="icon icon-umbrella"></i> 500
                            </a>
                        </li>

                        <li class="nav-item">
                            <a href="/index/settings" class="nav-link">
                                <i class="icon icon-umbrella"></i> Settings
                            </a>
                        </li>
                    </ul>
                </li>-->
            </ul>
        </nav>
    </div>
</@override>

<@override name="content">
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <div class="card p-4">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <div>
                                <span class="h4 d-block font-weight-normal mb-2">54</span>
                                <span class="font-weight-light">Total Users</span>
                            </div>

                            <div class="h2 text-muted">
                                <i class="icon icon-people"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card p-4">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <div>
                                <span class="h4 d-block font-weight-normal mb-2">$32,400</span>
                                <span class="font-weight-light">Income</span>
                            </div>

                            <div class="h2 text-muted">
                                <i class="icon icon-wallet"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card p-4">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <div>
                                <span class="h4 d-block font-weight-normal mb-2">900</span>
                                <span class="font-weight-light">Downloads</span>
                            </div>

                            <div class="h2 text-muted">
                                <i class="icon icon-cloud-download"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card p-4">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <div>
                                <span class="h4 d-block font-weight-normal mb-2">32s</span>
                                <span class="font-weight-light">Time</span>
                            </div>

                            <div class="h2 text-muted">
                                <i class="icon icon-clock"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row ">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            Total Users
                        </div>

                        <div class="card-body p-0">
                            <div class="p-4">
                                <canvas id="line-chart" width="100%" height="20"></canvas>
                            </div>

                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <div class="text-center">
                                    <div class="text-muted small">Total Traffic</div>
                                    <div>12,457 Users (40%)</div>
                                </div>

                                <div class="text-center">
                                    <div class="text-muted small">Banned Users</div>
                                    <div>95,333 Users (5%)</div>
                                </div>

                                <div class="text-center">
                                    <div class="text-muted small">Page Views</div>
                                    <div>957,565 Pages (50%)</div>
                                </div>

                                <div class="text-center">
                                    <div class="text-muted small">Total Downloads</div>
                                    <div>957,565 Files (100 TB)</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@override>

<!--继承的模板要写在最下面-->
<@extends name="/base.ftl"/>