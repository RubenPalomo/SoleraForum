import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Dropdown.scss";

function Dropdown(props) {
  const baseURL = "http://localhost:8090/form";
  const [threads, setThreads] = useState([]);
  const handleClickElement = props.handleClickElement;

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setThreads(response.data);
    });
  }, []);
  return (
    <div className="scroll">
      <div className="dropdown">
        <button type="button" className="dropbtn">
          Create a thread
        </button>
        <div className="content">
          {threads.map((element, index) => (
            <button
              key={index}
              className="thread"
              value={element}
              onClick={handleClickElement}
            >
              {element}
            </button>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Dropdown;
