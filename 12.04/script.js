console.log("Hello, World!");

function factorial(i) {
    // triple equals === strict type equality
    if (i === 0) {
        return 1;
    }

    return i * factorial(i - 1);
}

var a = null;
var b = undefined;
console.log("null is not undefined: " + (a != b))

var myObject = {}
myObject.hello = "World";
myObject["hello"] = "There";

var hello = "hello"
console.log(hello + " " + myObject[hello]);

function $(id) {
    return document.getElementById(id);
}

const CONTAINER = $("container");
const RESET = $("reset");
const SORT = $("sort");
const INTERACT = $("interact");

function reset() {
    CONTAINER.innerHTML = "";

    let newList = [];
    for (let i = 0; i < 10; ++i) {
        newList[i] = Math.round(Math.random() * 100);
    }

    paint(newList);
    SORT.disabled = false;
}

function sort() {
    let numberList = Array.from(CONTAINER.children[0].children).map((value) => parseInt(value.textContent))
    
    let sortedTail = 0;
    while (sortedTail != numberList.length) {
        let min = 99999;
        let minIndex = 99999;

        for (let i = sortedTail; i < numberList.length; ++i) {
            if (numberList[i] < min) {
                min = numberList[i];
                minIndex = i;
            }
        }

        let temp = numberList[sortedTail];
        numberList[sortedTail] = min;
        numberList[minIndex] = temp;

        ++sortedTail;
        paint(numberList);
    }

    SORT.disabled = true;
}

function paint(list) {
    const listContainer = document.createElement("div");
    listContainer.classList.add("numberContainer");
    for (const number of list) {
        const numberElement = document.createElement("div");
        numberElement.classList.add("number");
        numberElement.textContent = number;
        numberElement.style.backgroundColor = `rgba(255, 0, 0, ${number / 150})`;

        listContainer.appendChild(numberElement);
    }

    CONTAINER.appendChild(listContainer);
}

RESET.addEventListener("click", reset);
SORT.addEventListener("click", sort);

reset();

function dummyBlockingRequest(callback) {
    setTimeout(callback, 800);
}

setInterval(() => {
    dummyBlockingRequest(() => {
        const element = document.createElement("span");
        element.innerHTML = "Request received!<br/>";
        document.body.appendChild(element);
    })
}, 1500);

INTERACT.addEventListener("click", () => {
    const element = document.createElement("span");
    element.innerHTML = "Hello world!<br/>";
    document.body.appendChild(element); 
});
