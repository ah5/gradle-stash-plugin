package nebula.plugin.stash.tasks

import org.gradle.api.tasks.Input

public class DeleteBranchTask extends StashTask {
	@Input String branchName

	@Override
	public void executeStashCommand() {
		def existingBranch = stash
				.getBranchesMatching(branchName)
                .find { b -> b.displayId == branchName }
        if (!existingBranch) return
		
		stash.deleteBranch(branchName)
	}

}
