import React, { useState, useRef, useEffect } from "react";
import { WORDS } from "../data/words";
import { CategoryBtn } from "./CategoryBtn";

export const Quiz = () => {
 const [mode, setMode] = useState("all");
 const allWords = WORDS;

 const [curWords, setCurWords] = useState(allWords);

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
   if (answers[i].toUpperCase() === curWords[i].japaneese.toUpperCase()) r++;
  }
  setRes(r);
  setIsSubmitted(true);
 };

 const changeMode = (newMode) => {
  setMode(newMode);
  setCurWords(
   newMode !== "all"
    ? allWords.filter((item) => item.type === newMode)
    : allWords
  );
  setIsSubmitted(false);
  answersToNull();
 };

 return (
  <>
   <div className="flex justify-center my-5">
    <CategoryBtn changeMode={changeMode} mode={mode} newMode="all">
     Все
    </CategoryBtn>
    <CategoryBtn changeMode={changeMode} mode={mode} newMode="colors">
     Цвета
    </CategoryBtn>
    <CategoryBtn changeMode={changeMode} mode={mode} newMode="weather">
     Погода
    </CategoryBtn>
    <CategoryBtn changeMode={changeMode} mode={mode} newMode="school">
     Учеба
    </CategoryBtn>
   </div>

   {curWords.map((obj, index) => (
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
     Ваш результат: {`${res} / ${curWords.length}`}
    </div>
   )}
  </>
 );
};
