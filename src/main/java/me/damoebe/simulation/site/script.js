let steps = json.steps;
console.log(steps)
let i= 0;
let max = Math.max(...steps[0])
for (let e of steps[0]){
    let element = document.createElement("div");
    // element styling
    element.id = i.toString();
    element.title = "value~ " + Math.round(e).toString() + " original index: " + i.toString();
    element.style.viewTransitionName = "item-" + i.toString();
    element.style.height = ((e/max)*80).toString() + "vh";
    element.style.width = ((1/steps[0].length) * 100 -1).toString() +"%";
    element.style.float = "left";
    element.style.marginTop = "auto";
    element.style.display = "inline";
    element.style.backgroundColor = "rgb(" +((1/(e/max))*255).toString()  + ", " + ((e/max)*255).toString() + ", 100)";
    document.getElementById("box").appendChild(element);
    i++;
}
async function doSteps(steps){
    const box = document.getElementById("box");
    for (let step_index = 1; step_index < steps.length; step_index++) {
        let new_elements = [];
        for (let e_index = 0; e_index < steps[step_index].length; e_index++) {
            let index = steps[0].indexOf(steps[step_index][e_index]).toString();
            const element = document.getElementById(index);
            new_elements.push(element);
        }

        const transition = document.startViewTransition(() => {
            box.replaceChildren(...new_elements);
        });
        await transition.finished;
    }
}
doSteps(steps);



