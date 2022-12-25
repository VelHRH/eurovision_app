import React, { useState, useEffect } from "react";
import { WORDS } from "../data/words";
import { CategoryBtn } from "./CategoryBtn";
import { QuizContainer } from "./QuizContainer";
import { Result } from "./Result";
import { SubmitBtn } from "./SubmitBtn";

export const Quiz = () => {
 const [mode, setMode] = useState("all");
 const allWords = WORDS;

 const [curWords, setCurWords] = useState(allWords);

 const [answers, setAnswers] = useState(Array(curWords.length).fill(""));

 const [isSubmitted, setIsSubmitted] = useState(false);

 const [res, setRes] = useState(0);

 const onChangeInput = (val, index) => {
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
  console.log(curWords);
  console.log(answers);
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
    <CategoryBtn changeMode={changeMode} mode={mode} newMode="job">
     Работа
    </CategoryBtn>
    <CategoryBtn
     changeMode={changeMode}
     mode={mode}
     newMode="positive adjectives"
    >
     Положительные прилагательные
    </CategoryBtn>
   </div>
   <QuizContainer
    curWords={curWords}
    answers={answers}
    onChangeInput={onChangeInput}
   />
   <SubmitBtn handleSubmit={handleSubmit} />

   {isSubmitted && <Result curWords={curWords} res={res} />}
  </>
 );
};
