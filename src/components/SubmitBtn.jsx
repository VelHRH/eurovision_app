import React from "react";

export const SubmitBtn = ({ handleSubmit }) => {
 return (
  <button
   onClick={() => handleSubmit()}
   className="p-2 border-2 border-lime-600 text-lime-600 hover:bg-lime-600 text hover:text-slate-50 rounded-md ml-[50%] translate-x-[-50%] mt-5 ease-in duration-300 font-semibold"
  >
   Проверить
  </button>
 );
};
