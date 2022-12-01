import React from "react";

export const Field = (props) => {
 return (
  <div className="w-[90%] md:w-1/3 bg-lime-600 p-3 flex mb-2 rounded-2xl ml-[50%] translate-x-[-50%] text-xl font-semibold items-center">
   <div className="text-slate-50 w-1/4">{props.russian}</div>
   <input
    type="text"
    className="w-3/4 rounded-xl focus:outline-lime-800 p-2"
   ></input>
  </div>
 );
};
