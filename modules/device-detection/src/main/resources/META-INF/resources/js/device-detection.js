const getCookieValue = (name) => (
  document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')?.pop() || ''
)

let isMobileCookie = getCookieValue("device-detection-mobile");

let isMobile = window.matchMedia("only screen and (max-width: 760px)").matches;

if (isMobile) {
    document.cookie = "device-detection-mobile=true; path=/";
} else {
    document.cookie = "device-detection-mobile=false; path=/";
}

if(isMobileCookie != 'true' && isMobile) {
	location.reload();
}