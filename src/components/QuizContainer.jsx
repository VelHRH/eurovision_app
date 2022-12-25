import React from "react";

export const QuizContainer = ({ curWords, answers, onChangeInput }) => {
 return (
  <>
   {curWords.map((obj, index) => (
    <div className="w-[90%] md:w-1/3 bg-lime-600 p-3 flex mb-2 rounded-2xl ml-[50%] translate-x-[-50%] text-xl font-semibold items-center">
     <div className="text-slate-50 w-1/4 mr-2">{obj.russian}</div>
     <input
      key={index}
      type="text"
      onChange={(val) => {
       onChangeInput(val, index);
      }}
      className="w-3/4 rounded-xl focus:outline-lime-800 p-2"
      value={answers[index]}
     ></input>
    </div>
   ))}
  </>
 );
};
