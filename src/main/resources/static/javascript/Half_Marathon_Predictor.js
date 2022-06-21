 let hoursInput = document.getElementById("hours"),
  minutesInput = document.getElementById("minutes"),
  secondsInput = document.getElementById("seconds"),
  calculateBtn = document.getElementById("calculate_btn"),
  paceText = document.getElementById("pace");

calculateBtn.addEventListener("click", function () {
  let miles = 13.1,
    hours = parseFloat(hoursInput.value),
    minutes = parseFloat(minutesInput.value),
    seconds = parseFloat(secondsInput.value);

  if (isNaN(hours)) {
    hoursInput.style.borderColor = "red";
    return;
  } else {
    hoursInput.style.borderColor = "initial";
  }
  if (isNaN(minutes)) {
    minutesInput.style.borderColor = "red";
    return;
  } else {
    minutesInput.style.borderColor = "initial";
  }
  if (isNaN(seconds)) {
    secondsInput.style.borderColor = "red";
    return;
  } else {
    secondsInput.style.borderColor = "initial";
  }

  let totalMinutes = hours * 60 + minutes + seconds / 60,
    pace = totalMinutes / miles,
    paceMinutes = Math.floor(pace),
    paceSeconds = Math.round((pace - paceMinutes) * 60);

  if (paceSeconds < 10) {
    paceSeconds = "0" + paceSeconds;
  }

  paceText.textContent =
    "You need to run " + paceMinutes + ":" + paceSeconds + " minutes per mile.";
});
//Half Marathon Prediction Calculator:
let t1HoursInput = document.getElementById("t1hours"),
    t1MinutesInput = document.getElementById("t1minutes"),
    t1SecondsInput = document.getElementById("t1seconds"),

    d1Input = document.getElementById("d1"),

    predictor_calculate_btn = document.getElementById("predictor_calculate_btn"),
    predictor_pace = document.getElementById("predictor-pace");
    // predictor_calculate_btn.addEventListener("click",
    //  function () {
    //    let t1hours = parseFloat(t1HoursInput.value),
    //        t1minutes = parseFloat(t1MinutesInput.value),
    //        t1seconds = parseFloat(t1SecondsInput.value),
    //
    //        d1 = parseFloat(d1Input.value);
    //
    //    if (isNaN(t1hours)) {
    //      t1HoursInput.style.borderColor = "red";
    //      return;
    //    } else {
    //      t1HoursInput.style.borderColor = "initial";
    //    }
    //    if (isNaN(t1minutes)) {
    //      t1MinutesInput.style.borderColor = "red";
    //      return;
    //    } else {
    //      t1MinutesInput.style.borderColor = "initial";
    //    }
    //    if (isNaN(t1seconds)) {
    //      t1SecondsInput.style.borderColor = "red";
    //      return;
    //    } else {
    //      t1SecondsInput.style.borderColor = "initial";
    //    }
    //    if (isNaN(d1)) {
    //      d1Input.style.borderColor = "red";
    //      return;
    //    } else {
    //      d1Input.style.borderColor = "initial";
    //    }
    //    let T1TotalSeconds = (t1hours * 60 + t1minutes) * 60 + t1seconds,
    //        racePredictionSeconds = T1TotalSeconds * (13.1 / d1)^1.06,
    //        T2hours = Math.floor(racePredictionSeconds / 3600),
    //        T2minutes = Math.floor(racePredictionSeconds / 60) % 60,
    //        T2seconds = racePredictionSeconds % 60;
    //
    //    if (T2minutes < 10) {
    //        T2minutes = "0" + T2minutes;
    //    }
    //    if (T2seconds < 10) {
    //      T2seconds = "0" + T2seconds;
    //    }
    //
    //    let HMPrediction = "Your HM prediction is  " + T2hours + ":" +  T2minutes + ":" + T2seconds;
    //    predictor_pace.textContent = HMPrediction;
    //
    //    localStorage.setItem("halfMarathonPrediction",HMPrediction)
    //
    // });
   let prediction_button_submit = document.getElementById("hm-form")
    prediction_button_submit.addEventListener("submit", function (){

        let t1hours = parseFloat(t1HoursInput.value),
            t1minutes = parseFloat(t1MinutesInput.value),
            t1seconds = parseFloat(t1SecondsInput.value),

            d1 = parseFloat(d1Input.value);

        if (isNaN(t1hours)) {
            t1HoursInput.style.borderColor = "red";
            return;
        } else {
            t1HoursInput.style.borderColor = "initial";
        }
        if (isNaN(t1minutes)) {
            t1MinutesInput.style.borderColor = "red";
            return;
        } else {
            t1MinutesInput.style.borderColor = "initial";
        }
        if (isNaN(t1seconds)) {
            t1SecondsInput.style.borderColor = "red";
            return;
        } else {
            t1SecondsInput.style.borderColor = "initial";
        }
        if (isNaN(d1)) {
            d1Input.style.borderColor = "red";
            return;
        } else {
            d1Input.style.borderColor = "initial";
        }
        let T1TotalSeconds = (t1hours * 60 + t1minutes) * 60 + t1seconds,
            racePredictionSeconds = T1TotalSeconds * (13.1 / d1)^1.06,
            T2hours = Math.floor(racePredictionSeconds / 3600),
            T2minutes = Math.floor(racePredictionSeconds / 60) % 60,
            T2seconds = racePredictionSeconds % 60;

        if (T2minutes < 10) {
            T2minutes = "0" + T2minutes;
        }
        if (T2seconds < 10) {
            T2seconds = "0" + T2seconds;
        }

        let HMPrediction = "Your HM prediction is  " + T2hours + ":" +  T2minutes + ":" + T2seconds;
        predictor_pace.value = HMPrediction;

        localStorage.setItem("halfMarathonPrediction",HMPrediction);
        if(HMPrediction==null){
            console.log("FALSE");
            alert();
            return false;

        }
        return true;
    });




