// let inputWidth = 9;// prompt("Enter width");
// let inputHeigth = 5;//prompt("Enter heigth");

// for (let y = 1; y <= Number(inputHeigth); y++) {
//     let line ='';
//     for (let x = 1; x <= Number(inputWidth); x++) {
//         line+='*'
//     }
//     console.log(line+'\n');
// }

// let inputSize = 8

// for (let i = 0; i < inputSize; i++) {
//     let row = '';
//     for (let j = 0; j < inputSize; j++) {
//         if (i === j || i === inputSize - j - 1) {
//             row += '*';
//         } else {
//             row += ' ';
//         }
//     }
//     console.log(row);
// } 



// let inputSize = 6//prompt("Enter size");
// for (let y = inputSize; y > 0 ; y--) {
//     let line = '';
//     for (let x = inputSize-y; x > 0; x--) {
//         line += ' ';
//     }

//     for (let x = y; x > 0; x--) {
//         line += '*';
//     }
//     console.log(line);
// } 



// let inputSize = 8
// for (let y = 0; y < inputSize; y++) {
//     let line = '';
//     for (let x = 0; x <= y; x++) {
//             line += '*';
//     }   
//     console.log(line);
// } 


// let inputWidth = 12;// prompt("Enter width");
// let inputHeigth = 5;//prompt("Enter heigth");

// for (let y = 0, w =0; y <= inputHeigth; y++, w+=2) {
//     let line ='';
//     for (let x = y; x > 0; x--) {
//         line += ' ';
//     }
//     for (let x = inputWidth-w; x > 0; x--) {
//     line+='*'
//     }
//     console.log(line+'\n');
// }

// let inputWidth = 12;// prompt("Enter width");
// let inputHeigth = 5;//prompt("Enter heigth");
// let spaces = 0;
// let stars = inputWidth;


// for (let y = 0, w =0; y <= inputHeigth; y++, w+=2) {
//     let line ='';
//     for (let x = 0; x <= spaces; x++) {
//         line += ' ';
//     }
//     for (let x = stars; x > 0; x--) {
//         line+='*'
//     }
//     console.log(line+'\n');
//     spaces += 1;
//     stars -= 2;
// }


let inputWidth = 11
let inputHeigth = 6
for (let y = 1; y <= inputHeigth; y++) {
    let even = y % 2 == 0;
    let line = '';
    for (let x = 1; x <= inputWidth; x++) {
        if (even) {
            line += '*'
            even=false;
        } else {
            line += ' '
            even=true;
        }

    }
    console.log(line + '\n');
} 