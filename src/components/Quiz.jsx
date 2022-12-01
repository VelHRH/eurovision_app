import React, { useState, useRef, useEffect } from "react";
import { colors, school } from "../data/words";

export const Quiz = () => {
 const [mode, setMode] = useState("all");
 const allQuestions = colors.concat(school);

 const [curQuestions, setCurQuestions] = useState(allQuestions);

 const [answers, setAnswers] = useState([]);

 const [isSubmitted, setIsSubmitted] = useState(false);

 const [res, setRes] = useState(0);

 const onchangeInput = (val, index) => {
  let temp = answers.map((i) => i);
  temp[index] = val.target.value;
  setAnswers(temp);
 };

 const answersToNull = () => {
  for (let i = 0; i < answers.length; i++) {
   answers[i] = "";
  }
 };

 const handleSubmit = () => {
  let r = 0;
  for (let i = 0; i < answers.length; i++) {
   if (answers[i] === undefined) continue;
   if (answers[i].toUpperCase() === curQuestions[i].japaneese.toUpperCase())
    r++;
  }
  setRes(r);
  setIsSubmitted(true);
 };

 return (
  <>
   <div className="flex justify-center my-5">
    <button
     onClick={() => {
      setMode("all");
      setCurQuestions(allQuestions);
      setIsSubmitted(false);
      answersToNull();
     }}
     className={`border-2 border-slate-500 ${
      mode == "all"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md`}
    >
     Все
    </button>
    <button
     onClick={() => {
      setMode("colors");
      setCurQuestions(colors);
      setIsSubmitted(false);
      answersToNull();
     }}
     className={`border-2 border-slate-500 ${
      mode == "colors"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md ml-3`}
    >
     Цвета
    </button>
    <button
     onClick={() => {
      setMode("weather");
      setIsSubmitted(false);
      answersToNull();
     }}
     className={`border-2 border-slate-500 ${
      mode == "weather"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md ml-3`}
    >
     Погода
    </button>
    <button
     onClick={() => {
      setMode("school");
      setCurQuestions(school);
      setIsSubmitted(false);
      answersToNull();
     }}
     className={`border-2 border-slate-500 ${
      mode == "school"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md ml-3`}
    >
     Учеба
    </button>
   </div>

   {curQuestions.map((obj, index) => (
    <div className="w-[90%] md:w-1/3 bg-lime-600 p-3 flex mb-2 rounded-2xl ml-[50%] translate-x-[-50%] text-xl font-semibold items-center">
     <div className="text-slate-50 w-1/4 mr-2">{obj.russian}</div>
     <input
      key={index}
      type="text"
      onChange={(val) => {
       onchangeInput(val, index);
      }}
      className="w-3/4 rounded-xl focus:outline-lime-800 p-2"
      value={answers[index]}
     ></input>
    </div>
   ))}
   <button
    onClick={handleSubmit}
    className="p-2 border-2 border-lime-600 text-lime-600 hover:bg-lime-600 text hover:text-slate-50 rounded-md ml-[50%] translate-x-[-50%] mt-5 ease-in duration-300 font-semibold"
   >
    Проверить
   </button>

   {isSubmitted && (
    <div className="text-red-500 text-center font-bold text-3xl my-3">
     Ваш результат: {res}
    </div>
   )}
  </>
 );
};
