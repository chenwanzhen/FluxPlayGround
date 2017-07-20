function addEvent(event, elem, fuc) {
    if (elem.addEventListener)
        elem.addEventListener(event, fuc, false);
    else if (elem.attachEvent())
        elem.attachEvent("on" + event, fuc);
    else
        elem[event] = fuc;
}

function print(message) {
    var elem = document.createElement("spam");
    elem.innerHTML = message + '<br />';
    document.getElementById('output').appendChild(elem);
}