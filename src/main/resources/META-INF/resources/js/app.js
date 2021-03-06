async function getSchools() {
   let url = '/api/schools';
   try {
       let res = await fetch(url);
       console.log('schools loaded')
       return await res.json();
   } catch (error) {
       console.log(error);
   }
}

function renderStudent(student) {
   return `<div class="student"><a href="${student.link}">${student.name}</a></div>`
}

function renderSchool(school) {
   const students = renderList(school.students, renderStudent, 'ol')
   return `<div class="school">
      <h2><a href="${school.link}">${school.name}</a></h2>
      ${students}
   </div>`;
}

function renderSchools(schools) {
   return renderList(schools, renderSchool)
}

function renderList(items, renderItem, listType) {
   listType = listType || 'ul'
   return items.reduce((lst, item) => lst + '<li>' + renderItem(item) + '</li>', `<${listType}>`) + `</${listType}>`
}

async function updateSchools() {
   const response = await getSchools();
   const html = renderSchools(response.schools);
   let app = document.querySelector('#schools');
   app.innerHTML = html;
}

updateSchools()