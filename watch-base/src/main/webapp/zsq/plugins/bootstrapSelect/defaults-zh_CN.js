/*!
 * Bootstrap-select v1.6.3 (http://silviomoreto.github.io/bootstrap-select/)
 *
 * Copyright 2013-2014 bootstrap-select
 * Licensed under MIT (https://github.com/silviomoreto/bootstrap-select/blob/master/LICENSE)
 */
+function(root,factory){
    if (typeof define === 'function' && define.amd) {
        define(['jquery','./bootstrap-select'], factory);
    } else {
        factory(root.jQuery);
    }
}(window,function ($) {
	 $.fn.selectpicker.defaults = {
	    //noneSelectedText: '没有选中任何项',
	    noneSelectedText: '',
	    noneResultsText: '没有找到匹配项',
	    countSelectedText: '选中{1}中的{0}项',
	    maxOptionsText: ['超出限制 (最多选择{n}项)', '组选择超出限制(最多选择{n}组)'],
	    multipleSeparator: ', '
	  };
});
