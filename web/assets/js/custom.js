'use strict';

(function ($) {

    $(document).on('click', '.layout-builder .layout-builder-toggle', function () {
        $('.layout-builder').toggleClass('show');
    });

    $(window).on('load', function () {
        setTimeout(function () {
            $('.layout-builder').removeClass('show');
        }, 500);
    });

    var site_layout = localStorage.getItem('site_layout');
    site_layout = $.trim(site_layout);

    $('body').addClass(site_layout)
        .append(`
    <div class="layout-builder show">
        <div class="layout-builder-toggle shw">
            <i class="ti-settings"></i>
        </div>
        <div class="layout-builder-toggle hdn">
            <i class="ti-close"></i>
        </div>
        <div class="layout-builder-body">
            <h5>界面定制</h5>
            <div class="mb-3">
                <p>主题颜色</p>
                <div>
                    <div class="custom-control custom-radio ` + (site_layout == 'gradient-theme-1' ? 'active' : '') + `">
                      <input type="radio" class="custom-control-input"  name="layout" id="gradient-theme-1" data-layout="gradient-theme-1">
                      <label class="custom-control-label" for="gradient-theme-1">Color 1</label>
                    </div>
                    <div class="custom-control custom-radio ` + (site_layout == 'gradient-theme-2' ? 'active' : '') + `">
                      <input type="radio" class="custom-control-input" name="layout" id="gradient-theme-2" data-layout="gradient-theme-2">
                      <label class="custom-control-label" for="gradient-theme-2">Color 2</label>
                    </div>
                    <div class="custom-control custom-radio ` + (site_layout == 'gradient-theme-3' ? 'active' : '') + `">
                      <input type="radio" class="custom-control-input" name="layout" id="gradient-theme-3" data-layout="gradient-theme-3">
                      <label class="custom-control-label" for="gradient-theme-4">Color 2</label>
                    </div>
                    <div class="custom-control custom-radio ` + (site_layout == 'gradient-theme-4' ? 'active' : '') + `">
                      <input type="radio" class="custom-control-input" name="layout" id="gradient-theme-4" data-layout="gradient-theme-4">
                      <label class="custom-control-label" for="gradient-theme-4">Color 4</label>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <button id="btn-layout-builder-reset" class="btn btn-danger btn-uppercase">重置</button>
        </div>
    </div>`);

    $('.layout-builder .layout-builder-body .custom-radio').click(function () {
        var class_names = $(this).find('input[type="radio"]').data('layout');
        localStorage.setItem('site_layout', class_names);
        window.location.href = (window.location.href).replace('#', '');
    });

    $(document).on('click', '#btn-layout-builder-reset', function () {
        localStorage.removeItem('site_layout');
        localStorage.removeItem('site_layout_dark');

        window.location.href = (window.location.href).replace('#', '');
    });

    $(window).on('load', function () {
        if ($('body').hasClass('horizontal-side-menu') && $(window).width() > 768) {
            setTimeout(function () {
                $('.side-menu .side-menu-body > ul').append('<li><a href="#"><span>Other</span></a><ul></ul></li>');
            }, 100);
            $('.side-menu .side-menu-body > ul > li').each(function () {
                var index = $(this).index(),
                    $this = $(this);
                if (index > 7) {
                    setTimeout(function () {
                        $('.side-menu .side-menu-body > ul > li:last-child > ul').append($this.clone());
                        $this.addClass('d-none');
                    }, 100);
                }
            });
        }
    });

    $(document).on('click', '[data-attr="layout-builder-toggle"]', function () {
        $('.layout-builder').toggleClass('show');
        return false;
    });

})(jQuery);