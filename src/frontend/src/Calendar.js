import React from "react";
import Day from "./Day";

function Calendar({ days }) {
    console.log(days);
    return (
        <div className="calendar">
            {days.map((day, index) => (
                <Day key={index} date={day} />
            ))}
        </div>
    );
}

export default Calendar;
