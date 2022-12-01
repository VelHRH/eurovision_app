import React, { useState } from "react";
import { colors } from "../data/words";
import { Field } from "./Field";

export const Quiz = () => {
 const [mode, setMode] = useState("all");
 return (
  <>
   <div className="flex justify-center my-5">
    <button
     onClick={() => setMode("all")}
     className={`border-2 border-slate-500 ${
      mode == "all"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md`}
    >
     Все
    </button>
    <button
     onClick={() => setMode("colors")}
     className={`border-2 border-slate-500 ${
      mode == "colors"
       ? "text-slate-50 bg-slate-500"
       : "text-slate-500 bg-transparent"
     } font-semibold px-3 rounded-md ml-3`}
    >
     Цвета
    </button>
    <button
     onClick={() => setMode("weather")}
     className="border-2 border-slate-500 text-slate-500 font-semibold px-3 rounded-md ml-3"
    >
     Погода
    </button>
    <button
     onClick={() => setMode("school")}
     className="border-2 border-slate-500 text-slate-500 font-semibold px-3 rounded-md ml-3"
    >
     Учеба
    </button>
   </div>

   {colors.map((obj) => (
    <Field japaneese={obj.japaneese} russian={obj.russian} />
   ))}
   <button className="p-2 border-2 border-lime-600 text-lime-600 hover:bg-lime-600 text hover:text-slate-50 rounded-md ml-[50%] translate-x-[-50%] mt-5 ease-in duration-300 font-semibold">
    Проверить
   </button>
  </>
 );
};
