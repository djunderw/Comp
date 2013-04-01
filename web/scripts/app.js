/*global define */
define(function(require) {
    'use strict';

    var compTemplate = window.comp['web/templates/comp.html'];

    $.getJSON('http://localhost:8080/comp/service/seasons', function(result) {
    	console.log(result);
        $('#seasons').append(compTemplate(result));
    });

    return 'Initialized';
});