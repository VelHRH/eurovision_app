import React from "react";

export const Result = ({ res, curWords }) => {
 return (
  <div className="text-red-500 text-center font-bold text-3xl my-3">
   Ваш результат: {`${res} / ${curWords.length}`}
  </div>
 );
};
