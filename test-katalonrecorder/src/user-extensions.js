function toDateTime(timerEndsAt) {     // e.g., '21/02/2024 14:28'
  const re = new RegExp('([0-9]{2})/([0-9]{2})/([0-9]{4}) ([0-9]{2}):([0-9]{2})');
  const results = timerEndsAt.match(re);
  if (results) {
    const year = results[3] != null ? Number(results[3]) : 0;
    const monthMinus1 = results[2] != null ? Number(results[2]) : 0;
    const day = results[1] ? Number(results[1]) : 0;
    const hour = results[4] ? Number(results[4]) : 0;
    const minute = results[5] ? Number(results[5]) : 0;
    const date = new Date(year, monthMinus1, day, hour, minute);
    return date;
  } else {
    return null;
  }
}

function dateTimeDifferenceMinutes(timerEndsAt1, timerEndsAt2) {
  const dt1 = toDateTime(timerEndsAt1);
  const dt2 = toDateTime(timerEndsAt2);
  const diffMinutes = (dt2.getTime() - dt1.getTime()) / (1000 * 60);
  return diffMinutes;
}

export { toDateTime, dateTimeDifferenceMinutes }


// add custom Action "toDateTime" to Katalon Recorder

if (Selenium) {
  Selenium.prototype.doToDateTime(locator, text) {
    return toDateTime(this.getText(locator));
  }
}
// See https://docs.katalon.com/docs/katalon-platform/plugins-and-add-ons/katalon-recorder-extension/get-your-job-done/extend-katalon-recorder/extension-scripts-for-custom-locator-builders-and-actions-in-katalon-recorder#:~:text=Adding%20extension%20scripts%20into%20Katalon,tabs%20opened%20after%20being%20added
