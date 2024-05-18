        function handleClick(column) {
            switch (column) {
                case 'firstColumn':
                    alert("First column clicked");
                    // Example navigation
                     window.location.href = '/databaseProj/formProjUpdate.jsp';
                    break;
                case 'secondColumn':
                    alert("Second column clicked");
                    // Example navigation
                    // window.location.href = '/account';
                    break;
                case 'thirdColumn':
                    alert("Third column clicked");
                    // Example navigation
                     window.location.href = '/databaseProj/formProj.jsp';
                    break;
                default:
                    console.log("Unknown column");
            }
        }