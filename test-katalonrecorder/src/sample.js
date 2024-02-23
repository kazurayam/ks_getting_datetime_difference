import * as dtf from './user-extensions.js'

const timerEndsAt1 = '21/02/2024 14:28';
const timerEndsAt2 = '21/02/2024 15:01';

const diffMinutes2 = dtf.dateTimeDifferenceMinutes(timerEndsAt1, timerEndsAt2);
console.log(`difference: ${diffMinutes2} minutes`);
