function randomString() {
    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var string_length = 1;
    var randomstring = '';
    for (var i=0; i<string_length; i++) {
        var rnum = Math.floor(Math.random() * chars.length);
        randomstring += chars.charAt(rnum);
    }
    console.log(randomstring);
    document.getElementById("randomChar").innerHTML = randomstring;
}

function random_bg_color() {
    var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    var bgColor = "rgb(" + x + "," + y + "," + z + ")";
    console.log(bgColor);
    document.body.style.background = bgColor;
}

window.onload = function () {
    random_bg_color();
    randomString();
}