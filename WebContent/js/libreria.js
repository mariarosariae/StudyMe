$(document).ready(() => {
    //Aggiungo click listener
    const pacchetti = document.querySelectorAll(".pacchetto");
    const lezioni = document.querySelectorAll(".lezione");

    pacchetti.forEach(pacchetto => {
        $(pacchetto).click(onPacchettoClick);
    })

    lezioni.forEach(lezione => {
        $(lezione).click(onLezioneClick);
    })
});

const onPacchettoClick = event => {
    const caller = event.target;
    const lessonList = caller.querySelector(".lezioni");

    $(lessonList).slideToggle(400, () => {
        const icon = caller.querySelector("i");
        if(icon.classList.contains("fa-chevron-down"))
            icon.setAttribute("class", "fas fa-chevron-up")
        else {
            icon.setAttribute("class", "fas fa-chevron-down")
        }
    });
}

const onLezioneClick = event => {
    event.stopPropagation();
    const caller = event.target;

    const videoURL = caller.getAttribute("data");
    alert("Playing " + videoURL);
}
