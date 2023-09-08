import React, { useState, useEffect } from "react";
import Calendar from "./Calendar";

function CalendarApp() {
    const [days, setDays] = useState([]);
    const initialLoadCount = 10;
    const today = new Date();
    const initialDates = [];

    useEffect(() => {
        // Load initial days
        for (let i = 0; i < initialLoadCount; i++) {
            const date = new Date(today);
            date.setDate(today.getDate() + i); // Increment the date by 'i' days
            initialDates.push(date.toISOString()); // Store the date as an ISO string
        }
        setDays(initialDates); // Set 'days' to 'initialDates' instead of an empty array
    }, []);

    // Load more days as the user scrolls

    return (
        <div className="App">
            <Calendar days={days} />
        </div>
    );
}

export default CalendarApp;
