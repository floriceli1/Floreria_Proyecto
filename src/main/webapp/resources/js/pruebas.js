/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function resizeDiv() {
  vpw = $(window).width();
  vph = $(window).height();
  $('.viewport-height-slide').css({'height': vph + 'px'});
  //$('.carrusel').css({'height': vph + 'px'});
  //$('.post_carrusel').css({'height': vph + 'px'});
  //$('.panel').css({'height': vph + 'px'});
  //$('.carrusel_item').css({'height': vph + 'px'});
}

function calculateCarruselDimensions() {
  var total_width = 0;
  var total_global_width = 0;
  var amount_to_scroll = 0;

  $('.carrusel').find('.carrusel_item').each(function() {
    _this = $(this);
    _this.css('width', _this.find('img').width() + 'px');
    console.log(_this.find('img').width());
    total_width += _this.find('img').width();
    //console.log( _this.attr('id') + '=' + total_width );
  });

  total_global_width = total_width;
  $('.carrusel').find('.panel').css('width', total_global_width + 'px');
  amount_to_scroll = total_global_width - $(window).width();

  return amount_to_scroll;
}

$(window).on("load", function() {
  if ($('.carrusel').length) {
    var controller = new ScrollMagic.Controller();
    var horizontalSlide = new TimelineMax();

    $('.carrusel').imagesLoaded(function() {

      amount_to_scroll = calculateCarruselDimensions();
      console.log(amount_to_scroll);

      horizontalSlide.fromTo("#slideContainer", 10,
                             {
        x: "0"
      }, {
        x: amount_to_scroll * (-1) + 'px',
        ease: Linear.easeNone,
      });

      scene = new ScrollMagic.Scene({
        triggerElement: "#slideWrapper",
        triggerHook: "onLeave",
        duration: amount_to_scroll + 'px' }).
      setPin("#slideWrapper").
      setTween(horizontalSlide).
      addTo(controller);
    });
  }
});



$(document).ready(function(){
  resizeDiv();
});

window.onresize = function() {
  resizeDiv();
};

$(window).bind("resize", function() {
  amount_to_scroll = calculateCarruselDimensions();
  //console.log(amount_to_scroll);
  scene.duration(amount_to_scroll + 'px');
});