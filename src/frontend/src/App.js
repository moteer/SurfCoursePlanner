import React, {useEffect, useState} from 'react';

function App() {
    const [data, setData] = useState(null);

    useEffect(() => {
// Fetch JSON data from an example API
        fetch('http://localhost:8080/api/surfcalendar/all',
            {method :'GET', credentials: 'include'})
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => console.error('Error:', error));
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <h1>JSON Fetch Example</h1>
                {data ? (
                    <pre>{JSON.stringify(data, null, 2)}</pre>
                ) : (
                    <p>Loading data...</p>
                )}
            </header>
        </div>
    );
}

export default App;
