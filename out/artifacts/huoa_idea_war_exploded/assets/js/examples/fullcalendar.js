'use strict';
$(document).ready(function () {

    var events = [
        {
            title: 'Business Lunch',
            start: '2019-03-03T13:00:00',
            constraint: 'businessHours',
            className: 'bg-danger'
        },
        {
            title: 'Meeting',
            start: '2019-03-13T11:00:00',
            constraint: 'availableForMeeting',
            color: '#257e4a',
            className: 'bg-success'
        },
        {
            title: 'Conference',
            start: '2019-03-18',
            end: '2019-01-20',
            className: 'bg-warning'
        },
        {
            title: 'Party',
            start: '2019-03-18T20:00:00'
        },
        {
            id: 'availableForMeeting',
            start: '2019-03-11T10:00:00',
            end: '2019-04-11T16:00:00',
            rendering: 'background'
        },
        {
            id: 'availableForMeeting',
            start: '2019-03-13T10:00:00',
            end: '2019-03-13T16:00:00',
            rendering: 'background'
        },
        {
            start: '2019-03-24',
            end: '2019-03-29',
            overlap: false,
            rendering: 'background',
            color: '#ff9f89'
        },
        {
            start: '2019-03-06',
            end: '2019-03-29',
            overlap: false,
            rendering: 'background',
            color: '#ff9f89'
        }
    ];

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
        },
        weekNumbers: true,
        eventLimit: true, // allow "more" link when too many events
        events: events
    });

    $('#external-events .fc-event').each(function () {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true // maintain when user navigates (see docs on the renderEvent method)
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });

    $('#calendar-demo2').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
        },
        editable: true,
        droppable: true,
        drop: function () {
            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove();
            }
        },
        weekNumbers: true,
        eventLimit: true, // allow "more" link when too many events
        events: events
    });

    $('#calendar-demo3').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'listDay,listWeek,month'
        },

        views: {
            listDay: {buttonText: 'list day'},
            listWeek: {buttonText: 'list week'}
        },

        defaultView: 'listWeek',
        defaultDate: '2019-01-12',
        navLinks: true,
        editable: true,
        eventLimit: true,
        events: [
            {
                title: 'All Day Event',
                start: '2019-01-01',
                className: 'bg-danger'
            },
            {
                title: 'Long Event',
                start: '2019-01-07',
                end: '2019-01-10'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2019-01-09T16:00:00'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2019-01-16T16:00:00'
            },
            {
                title: 'Conference',
                start: '2019-01-11',
                end: '2019-01-13'
            },
            {
                title: 'Meeting',
                start: '2019-01-12T10:30:00',
                end: '2019-01-12T12:30:00',
            },
            {
                title: 'Lunch',
                start: '2019-01-12T12:00:00'
            },
            {
                title: 'Meeting',
                start: '2019-01-12T14:30:00'
            },
            {
                title: 'Happy Hour',
                start: '2019-01-12T17:30:00'
            },
            {
                title: 'Dinner',
                start: '2019-01-12T20:00:00'
            },
            {
                title: 'Birthday Party',
                start: '2019-01-13T07:00:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2019-01-28'
            }
        ]
    });

});