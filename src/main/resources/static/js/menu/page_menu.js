function initMenu() {
    let menuList='   <li class="nav-item active"> ' +
        '              <a href="index.html"><i class="mdi mdi-home"></i> 后台首页</a> ' +
        '           </li>' +
        '            <li class="nav-item nav-item-has-subnav">\n' +
        '              <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>设备管理 </a>   ' +
        '              <ul class="nav nav-subnav">\n' +
        '                <li> <a href="lyear_ui_buttons.html">按钮</a> </li>' +
        '               </ul>' +
        '            </li>';
    $('#menu_dox').html(menuList);
}

function initTheme() {
    let theme= '  <span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>\n' +
        '\t\t\t  <ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">\n' +
        '                <li class="drop-title"><p>主题</p></li>\n' +
        '                <li class="drop-skin-li theme_box">\n' +
        '                  <span class="inverse">\n' +
        '                    <input type="radio" name="site_theme" value="default" id="site_theme_1" checked>\n' +
        '                    <label for="site_theme_1"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="site_theme" value="dark" id="site_theme_2">\n' +
        '                    <label for="site_theme_2"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="site_theme" value="translucent" id="site_theme_3">\n' +
        '                    <label for="site_theme_3"></label>\n' +
        '                  </span>\n' +
        '                </li>\n' +
        '\t\t\t    <li class="drop-title"><p>LOGO</p></li>\n' +
        '\t\t\t\t<li class="drop-skin-li clearfix logo_bg">\n' +
        '                  <span class="inverse">\n' +
        '                    <input type="radio" name="logo_bg" value="default" id="logo_bg_1" checked>\n' +
        '                    <label for="logo_bg_1"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_2" id="logo_bg_2">\n' +
        '                    <label for="logo_bg_2"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_3" id="logo_bg_3">\n' +
        '                    <label for="logo_bg_3"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_4" id="logo_bg_4">\n' +
        '                    <label for="logo_bg_4"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_5" id="logo_bg_5">\n' +
        '                    <label for="logo_bg_5"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_6" id="logo_bg_6">\n' +
        '                    <label for="logo_bg_6"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_7" id="logo_bg_7">\n' +
        '                    <label for="logo_bg_7"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="logo_bg" value="color_8" id="logo_bg_8">\n' +
        '                    <label for="logo_bg_8"></label>\n' +
        '                  </span>\n' +
        '\t\t\t\t</li>\n' +
        '\t\t\t\t<li class="drop-title"><p>头部</p></li>\n' +
        '\t\t\t\t<li class="drop-skin-li header_bg">\n' +
        '                  <span class="inverse">\n' +
        '                    <input type="radio" name="header_bg" value="default" id="header_bg_1" checked>\n' +
        '                    <label for="header_bg_1"></label>                      \n' +
        '                  </span>                                                    \n' +
        '                  <span>                                                     \n' +
        '                    <input type="radio" name="header_bg" value="color_2" id="header_bg_2">\n' +
        '                    <label for="header_bg_2"></label>                      \n' +
        '                  </span>                                                    \n' +
        '                  <span>                                                     \n' +
        '                    <input type="radio" name="header_bg" value="color_3" id="header_bg_3">\n' +
        '                    <label for="header_bg_3"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="header_bg" value="color_4" id="header_bg_4">\n' +
        '                    <label for="header_bg_4"></label>                      \n' +
        '                  </span>                                                    \n' +
        '                  <span>                                                     \n' +
        '                    <input type="radio" name="header_bg" value="color_5" id="header_bg_5">\n' +
        '                    <label for="header_bg_5"></label>                      \n' +
        '                  </span>                                                    \n' +
        '                  <span>                                                     \n' +
        '                    <input type="radio" name="header_bg" value="color_6" id="header_bg_6">\n' +
        '                    <label for="header_bg_6"></label>                      \n' +
        '                  </span>                                                    \n' +
        '                  <span>                                                     \n' +
        '                    <input type="radio" name="header_bg" value="color_7" id="header_bg_7">\n' +
        '                    <label for="header_bg_7"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="header_bg" value="color_8" id="header_bg_8">\n' +
        '                    <label for="header_bg_8"></label>\n' +
        '                  </span>\n' +
        '\t\t\t\t</li>\n' +
        '\t\t\t\t<li class="drop-title"><p>侧边栏</p></li>\n' +
        '\t\t\t\t<li class="drop-skin-li sidebar_bg">\n' +
        '                  <span class="inverse">\n' +
        '                    <input type="radio" name="sidebar_bg" value="default" id="sidebar_bg_1" checked>\n' +
        '                    <label for="sidebar_bg_1"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_2" id="sidebar_bg_2">\n' +
        '                    <label for="sidebar_bg_2"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_3" id="sidebar_bg_3">\n' +
        '                    <label for="sidebar_bg_3"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_4" id="sidebar_bg_4">\n' +
        '                    <label for="sidebar_bg_4"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_5" id="sidebar_bg_5">\n' +
        '                    <label for="sidebar_bg_5"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_6" id="sidebar_bg_6">\n' +
        '                    <label for="sidebar_bg_6"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_7" id="sidebar_bg_7">\n' +
        '                    <label for="sidebar_bg_7"></label>\n' +
        '                  </span>\n' +
        '                  <span>\n' +
        '                    <input type="radio" name="sidebar_bg" value="color_8" id="sidebar_bg_8">\n' +
        '                    <label for="sidebar_bg_8"></label>\n' +
        '                  </span>\n' +
        '\t\t\t\t</li>\n' +
        '\t\t\t  </ul>\n';
    $('.dropdown-skin').html(theme);
}


/*            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>设备管理 (UI 元素）</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_ui_buttons.html">按钮</a> </li>
                <li> <a href="lyear_ui_cards.html">卡片</a> </li>
                <li> <a href="lyear_ui_grid.html">格栅</a> </li>
                <li> <a href="lyear_ui_icons.html">图标</a> </li>
                <li> <a href="lyear_ui_tables.html">表格</a> </li>
                <li> <a href="lyear_ui_modals.html">模态框</a> </li>
                <li> <a href="lyear_ui_tooltips_popover.html">提示 / 弹出框</a> </li>
                <li> <a href="lyear_ui_alerts.html">警告框</a> </li>
                <li> <a href="lyear_ui_pagination.html">分页</a> </li>
                <li> <a href="lyear_ui_progress.html">进度条</a> </li>
                <li> <a href="lyear_ui_tabs.html">标签页</a> </li>
                <li> <a href="lyear_ui_typography.html">排版</a> </li>
                <li> <a href="lyear_ui_step.html">步骤</a> </li>
                <li> <a href="lyear_ui_other.html">其他</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 表单</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_forms_elements.html">基本元素</a> </li>
                <li> <a href="lyear_forms_radio.html">单选框</a> </li>
                <li> <a href="lyear_forms_checkbox.html">复选框</a> </li>
                <li> <a href="lyear_forms_switch.html">开关</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 示例页面</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_pages_doc.html">文档列表</a> </li>
                <li> <a href="lyear_pages_gallery.html">图库列表</a> </li>
                <li> <a href="lyear_pages_config.html">网站配置</a> </li>
                <li> <a href="lyear_pages_rabc.html">设置权限</a> </li>
                <li> <a href="lyear_pages_add_doc.html">新增文档</a> </li>
                <li> <a href="lyear_pages_guide.html">表单向导</a> </li>
                <li> <a href="login.html">登录页面</a> </li>
                <li> <a href="lyear_pages_error.html">错误页面</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i> JS 插件</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">日期选取器</a> </li>
                <li> <a href="lyear_js_sliders.html">滑块</a> </li>
                <li> <a href="lyear_js_colorpicker.html">选色器</a> </li>
                <li> <a href="lyear_js_chartjs.html">Chart.js</a> </li>
                <li> <a href="lyear_js_jconfirm.html">对话框</a> </li>
                <li> <a href="lyear_js_tags_input.html">标签插件</a> </li>
                <li> <a href="lyear_js_notify.html">通知消息</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-menu"></i> 多级菜单</a>
              <ul class="nav nav-subnav">
                <li> <a href="#!">一级菜单</a> </li>
                <li class="nav-item nav-item-has-subnav">
                  <a href="#!">一级菜单</a>
                  <ul class="nav nav-subnav">
                    <li> <a href="#!">二级菜单</a> </li>
                    <li class="nav-item nav-item-has-subnav">
                      <a href="#!">二级菜单</a>
                      <ul class="nav nav-subnav">
                        <li> <a href="#!">三级菜单</a> </li>
                        <li> <a href="#!">三级菜单</a> </li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li> <a href="#!">一级菜单</a> </li>
              </ul>
            </li>*/