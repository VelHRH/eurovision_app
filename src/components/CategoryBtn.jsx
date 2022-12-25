import React from "react";

export const CategoryBtn = ({ children, changeMode, newMode, mode }) => {
 return (
  <button
   onClick={() => changeMode(newMode)}
   className={`border-2 border-slate-500 ${
    mode == newMode
     ? "text-slate-50 bg-slate-500"
     : "text-slate-500 bg-transparent"
   } font-semibold px-3 rounded-md ml-3`}
  >
   {children}
  </button>
 );
};
